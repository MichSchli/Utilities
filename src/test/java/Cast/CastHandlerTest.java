package Cast;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import Cast.CastException;
import Cast.CastHandler;


public class CastHandlerTest {

	@Test
	public void Error_ImpossibleCast(){
		CastHandler caster = new CastHandler();
		try {
			caster.<String>cast("holyshitfuckabc", String.class, ICastHandler.class);
			fail("No exception thrown");
		} catch (CastException e) {
			Assert.assertEquals("Cannot cast String to ICastHandler", e.getMessage());
		}
	}
	
	@Test
	public void Cast_StringToInt() throws CastException{
		ICastHandler caster = new CastHandler();
		int cast = (Integer) caster.<String>cast("27", String.class, Integer.class);
		Assert.assertEquals(27, cast);
	}
	
	@Test
	public void Error_StringToInt(){
		ICastHandler caster = new CastHandler();
		try {
			caster.<String>cast("abc27", String.class, Integer.class);
			fail("No exception thrown");
		} catch (CastException e) {
			Assert.assertEquals("Cannot cast String \"abc27\" to Integer", e.getMessage());
		}
	}
}
