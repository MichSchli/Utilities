package Serialization.Json;

import java.util.ArrayList;

import Serialization.ISerializable;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class JsonSerializerTest extends TestCase {

	private class FakeClass implements ISerializable{
		String value;
		ArrayList<String> others;
		int intValue;
		
		public FakeClass() {
			others = new ArrayList<String>();
		}
	}
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public JsonSerializerTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( JsonSerializerTest.class );
    }
    
    public void testSerialize_ToString_Simple() throws Exception{
    	JsonSerializer serializer = new JsonSerializer();
    	
    	FakeClass fake = new FakeClass();
    	fake.value = "27";
    	
    	String s = serializer.serializeAsString(fake);
    	
    	assertEquals("{"
    			+ "\"value\":\""+fake.value+"\","
    			+ "\"others\":[],"
    			+ "\"intValue\":"+fake.intValue
    					+ "}", s);
    }
    
    public void testSerialize_ToString_WithInt() throws Exception{
    	JsonSerializer serializer = new JsonSerializer();
    	
    	FakeClass fake = new FakeClass();
    	fake.intValue = 129;
    	
    	String s = serializer.serializeAsString(fake);
    	
    	assertEquals("{"
    			+ "\"others\":[],"
    			+ "\"intValue\":"+fake.intValue
    					+ "}", s);
    }
    
    public void testSerialize_ToString_NullString() throws Exception{
    	JsonSerializer serializer = new JsonSerializer();
    	
    	FakeClass fake = new FakeClass();
    	
    	String s = serializer.serializeAsString(fake);
    	
    	assertEquals("{"
    			+ "\"others\":[],"
    			+ "\"intValue\":"+fake.intValue
    					+ "}", s);
    }
    
    public void testSerialize_ToString_WithList() throws Exception{
    	JsonSerializer serializer = new JsonSerializer();
    	
    	FakeClass fake = new FakeClass();
    	fake.others.add("hejabc");
    	fake.others.add("afed");
    	
    	String s = serializer.serializeAsString(fake);
    	
    	assertEquals("{"
    			+ "\"others\":[\"hejabc\",\"afed\"],"
    			+ "\"intValue\":"+fake.intValue
    					+ "}", s);
    }

    
    public void testDeserialize_FromString_NullField() throws Exception{
    	JsonSerializer serializer = new JsonSerializer();
    	
    	FakeClass fake = new FakeClass();
    	
    	String s = serializer.serializeAsString(fake);
    	FakeClass deserialized = serializer.<FakeClass>deserializeString(s, FakeClass.class);
    	
    	assertNull(deserialized.value);
    }
    
    public void testDeserialize_FromString_Simple() throws Exception{
    	JsonSerializer serializer = new JsonSerializer();
    	
    	FakeClass fake = new FakeClass();
    	fake.value = "27";
    	
    	String s = serializer.serializeAsString(fake);
    	FakeClass deserialized = serializer.<FakeClass>deserializeString(s, FakeClass.class);
    	
    	assertEquals(fake.value, deserialized.value);
    }
    
    public void testDeserialize_FromString_ConstructorCalled() throws Exception{
    	JsonSerializer serializer = new JsonSerializer();
    	
    	FakeClass fake = new FakeClass();
    	
    	String s = serializer.serializeAsString(fake);
    	FakeClass deserialized = serializer.<FakeClass>deserializeString(s, FakeClass.class);
    	
    	assertNotNull(deserialized.others);
    	assertTrue(deserialized.others.isEmpty());
    }
    
    public void testDeserialize_FromString_WithInt() throws Exception{
    	JsonSerializer serializer = new JsonSerializer();
    	
    	FakeClass fake = new FakeClass();
    	fake.intValue = 129;
    	
    	String s = serializer.serializeAsString(fake);
    	FakeClass deserialized = serializer.<FakeClass>deserializeString(s, FakeClass.class);
    	
    	assertEquals(fake.intValue, deserialized.intValue);
    }
    
    public void testDeserialize_FromString_WithList() throws Exception{
    	JsonSerializer serializer = new JsonSerializer();
    	
    	FakeClass fake = new FakeClass();
    	fake.others.add("hejabc");
    	fake.others.add("afed");
    	
    	String s = serializer.serializeAsString(fake);
    	FakeClass deserialized = serializer.<FakeClass>deserializeString(s, FakeClass.class);
    	
    	assertEquals(fake.others, deserialized.others);
    }
}
