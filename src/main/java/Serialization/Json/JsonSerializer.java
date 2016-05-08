package Serialization.Json;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Serialization.ISerializable;
import Serialization.ISerializer;

public class JsonSerializer implements ISerializer{

	private Gson gson;
	
	public JsonSerializer() {
		gson = new Gson();
	}
	
	public String serializeAsString(ISerializable item) {
		return gson.toJson(item);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <TItem extends ISerializable> TItem deserializeString(String string, Class<TItem> deserializeTo) {
		Object result = gson.fromJson(string, deserializeTo);
		return (TItem) result;
	}
}
