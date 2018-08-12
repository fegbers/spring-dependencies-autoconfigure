package de.fegbers.spring.dependencies.autoconfigure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Iterator;

import org.junit.Test;
import org.springframework.boot.info.InfoProperties.Entry;

public class DependenciesPropertiesTest implements SpringDependenciesAutoconfigureTestSupport
{
	@Test
	public void testConstructor()
	{
		DependenciesProperties dependenciesProperties = new DependenciesProperties(getExampleProperties());

		Iterator<Entry> iterator = dependenciesProperties.iterator();
		Entry dependency1 = iterator.next();
		Entry dependency2 = iterator.next();
		assertFalse(iterator.hasNext());

		assertEquals(dependency1.getKey(), "dependency_de_fegbers_dependency1_jar");
		assertEquals(dependency1.getValue(), "1.1.4-RELEASE");
		assertEquals(dependency2.getKey(), "dependency_de_fegbers_dependency2");
		assertEquals(dependency2.getValue(), "0.5.3");
	}
}
