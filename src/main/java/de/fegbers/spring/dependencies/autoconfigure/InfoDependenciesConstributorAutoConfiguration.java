package de.fegbers.spring.dependencies.autoconfigure;

import org.springframework.boot.actuate.autoconfigure.info.InfoContributorAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@AutoConfigureAfter(InfoContributorAutoConfiguration.class)
public class InfoDependenciesConstributorAutoConfiguration
{
	@Bean
	@ConditionalOnMissingBean
	@Order(InfoContributorAutoConfiguration.DEFAULT_ORDER)
	public DependenciesInfoConstributor dependencyInfoContributor(DependenciesProperties dependenciesProperties)
	{
		return new DependenciesInfoConstributor(dependenciesProperties);
	}
}
