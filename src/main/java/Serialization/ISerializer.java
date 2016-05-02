package Serialization;

public interface ISerializer<TItem extends ISerializable> {
	
	public TItem deserializeString(String string);
	public TItem deserializeBytes(byte[] bytes);
	
	public String serializeAsString(TItem item);
	public byte[] serializeAsBytes(TItem item);
}
