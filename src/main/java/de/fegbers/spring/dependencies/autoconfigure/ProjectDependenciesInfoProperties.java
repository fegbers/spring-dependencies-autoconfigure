package de.fegbers.spring.dependencies.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@ConfigurationProperties(prefix = "spring.info.dependencies")
public class ProjectDependenciesInfoProperties
{
	private Resource location = new ClassPathResource("dependencies.properties");

	public Resource getLocation()
	{
		return location;
	}

	public void setLocation(Resource location)
	{
		this.location = location;
	}
}
