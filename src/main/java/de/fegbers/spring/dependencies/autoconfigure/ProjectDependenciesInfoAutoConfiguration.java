package de.fegbers.spring.dependencies.autoconfigure;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Configuration
@EnableConfigurationProperties(ProjectDependenciesInfoProperties.class)
public class ProjectDependenciesInfoAutoConfiguration
{
	@Autowired
	private ProjectDependenciesInfoProperties projectDependenciesInfoProperties;

	@Conditional(DependenciesResourceAvailableCondition.class)
	@ConditionalOnMissingBean(DependenciesProperties.class)
	@Bean
	public DependenciesProperties dependenciesProperties() throws IOException
	{
		return new DependenciesProperties(loadFromResource(projectDependenciesInfoProperties.getLocation()));
	}

	private Properties loadFromResource(Resource location) throws IOException
	{
		String prefix = "dependency_";
		Properties source = PropertiesLoaderUtils.loadProperties(location);
		Properties target = new Properties();
		for (String key : source.stringPropertyNames())
		{
			if (key.startsWith(prefix))
			{
				target.put(key.substring(prefix.length()), source.get(key));
			}
		}
		return target;
	}

	static class DependenciesResourceAvailableCondition extends SpringBootCondition
	{
		@Override
		public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata)
		{
			ResourceLoader loader = context.getResourceLoader();
			String location = "classpath:dependencies.properties";

			ConditionMessage.Builder message = ConditionMessage.forCondition("DependenciesResource");
			if (loader.getResource(location).exists())
			{
				return ConditionOutcome.match(message.found("dependencies info at").items(location));
			}
			return ConditionOutcome.noMatch(message.didNotFind("dependencies info at").items(location));
		}
	}
}
