package Configuration;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class ConfigurationMapperTest {

	private class FakeConfiguration implements IConfiguration{
		
	}
	
	@Test
	public void Error_UnknownConfiguration(){
		ConfigurationMapper mapper = new ConfigurationMapper();
		try {
			mapper.mapHeader("NoSuchConfig");
			fail("No exception thrown");
		} catch (ConfigurationException e) {
			Assert.assertEquals("Configuration not known: NoSuchConfig", e.getMessage());
		}
	}
	
	@Test
	public void MapHeader_SomeConfiguration() throws ConfigurationException{
		ConfigurationMapper mapper = new ConfigurationMapper();
		IConfiguration configIn = new FakeConfiguration();
		
		String nameString = "FakeConfigHeader";
		
		mapper.addHeader(nameString, configIn);
		
		IConfiguration configOut = mapper.mapHeader(nameString);
	
		assertEquals(FakeConfiguration.class, configOut.getClass());
	}
}
