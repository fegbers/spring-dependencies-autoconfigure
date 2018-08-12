package de.fegbers.spring.dependencies.autoconfigure;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import de.fegbers.spring.dependencies.autoconfigure.ProjectDependenciesInfoProperties;

public class ProjectDependenciesInfoPropertiesTest
{
	@Test
	public void testDefaults() throws IOException
	{
		ProjectDependenciesInfoProperties properties = new ProjectDependenciesInfoProperties();
		assertEquals("dependencies.properties", properties.getLocation().getFile().getName());
	}
}
