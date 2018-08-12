package de.fegbers.spring.dependencies.autoconfigure;

import java.util.Properties;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoPropertiesInfoContributor;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;

public class DependenciesInfoConstributor extends InfoPropertiesInfoContributor<DependenciesProperties>
{
	protected DependenciesInfoConstributor(DependenciesProperties properties)
	{
		super(properties, Mode.FULL);
	}

	@Override
	public void contribute(Builder builder)
	{
		builder.withDetail("dependencies", generateContent());
	}

	@Override
	protected PropertySource<?> toSimplePropertySource()
	{
		Properties props = new Properties();
		getProperties().forEach(dependency ->
		{
			props.put(dependency.getKey(), dependency.getValue());
		});
		return new PropertiesPropertySource("dependency", props);
	}
}
