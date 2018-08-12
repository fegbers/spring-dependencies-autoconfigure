package de.fegbers.spring.dependencies.autoconfigure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.Map;

import org.junit.Test;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;

import de.fegbers.spring.dependencies.autoconfigure.DependenciesInfoConstributor;

public class DependenciesInfoConstributorTest implements SpringDependenciesAutoconfigureTestSupport
{
	@Test
	@SuppressWarnings("unchecked")
	public void testGenerateContent()
	{
		Info.Builder builder = new Info.Builder();

		InfoContributor infoContributor = new DependenciesInfoConstributor(getExampleDependenciesProperties());
		infoContributor.contribute(builder);

		Info info = builder.build();
		assertThat(info.getDetails()).containsOnlyKeys("dependencies");
		assertThat((Map<String, String>) info.getDetails().get("dependencies")).containsExactly(
				entry("dependency_de_fegbers_dependency1_jar", "1.1.4-RELEASE"),
				entry("dependency_de_fegbers_dependency2", "0.5.3"));
	}
}
