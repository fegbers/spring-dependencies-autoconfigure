package de.fegbers.spring.dependencies.autoconfigure;

import java.util.Properties;

public interface SpringDependenciesAutoconfigureTestSupport
{
	default DependenciesProperties getExampleDependenciesProperties()
	{
		return new DependenciesProperties(getExampleProperties());
	}

	default Properties getExampleProperties()
	{
		Properties properties = new Properties();
		properties.put("dependency_de_fegbers_dependency1_jar", "1.1.4-RELEASE");
		properties.put("dependency_de_fegbers_dependency2", "0.5.3");
		return properties;
	}
}
