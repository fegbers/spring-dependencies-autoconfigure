package de.fegbers.spring.dependencies.autoconfigure;

import java.util.Properties;

import org.springframework.boot.info.InfoProperties;

public class DependenciesProperties extends InfoProperties
{
	public DependenciesProperties(Properties entries)
	{
		super(entries);
	}
}
