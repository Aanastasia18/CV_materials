package config;

import java.util.HashMap;
import java.util.Map;

import domain.User;

public class ConfigProvider {

	protected Map <String, String> configMap = new HashMap<String, String>();
	
	public ConfigProvider() {}
	
	public ConfigProvider(Map<String, String>mapFrom) {
		configMap = mapFrom;
	}
	
	public void set(String key, String value) {
		configMap.put(key, value);
	}
	
	public String get(String key) {
		return configMap.get(key);
	}
	
	public void remove(String key) {
		configMap.remove(key);
	}
	
	public void viewDetails() {
		User u = new User();
	}
	
	
}
