package Configuration;

import java.util.HashMap;

public class ConfigurationMapper implements IConfigurationMapper {

	private HashMap<String, IConfiguration> configMaps;

	public ConfigurationMapper() {
		configMaps = new HashMap<String, IConfiguration>();
	}
	
	public IConfiguration mapHeader(String key) throws ConfigurationException {
		IConfiguration config = configMaps.get(key);
		
		if (config == null){
			throw new ConfigurationException("Configuration not known: "+key);
		}
		
		return config;
	}

	public void addHeader(String nameString, IConfiguration configIn) {
		configMaps.put(nameString, configIn);
	}

}
