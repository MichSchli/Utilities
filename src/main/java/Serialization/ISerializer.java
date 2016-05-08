package Serialization;

public interface ISerializer {
	
	public <TItem extends ISerializable>TItem deserializeString(String string, Class<TItem> deserializeTo);	
	public String serializeAsString(ISerializable item);
}
