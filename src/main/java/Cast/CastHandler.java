package Cast;

public class CastHandler implements ICastHandler{

	public <TIn> Object cast(TIn inValue, Class<?> inClass, Class<?> outClass) throws CastException {
		
		if (inClass.equals(String.class) && outClass.equals(Integer.class)){
			return stringToInt((String) inValue);
		}
		
		throw new CastException("Cannot cast "+inClass.getSimpleName()+" to "+outClass.getSimpleName());
	}

	private Integer stringToInt(String string) throws CastException{
		try {
			return Integer.parseInt(string);			
		} catch (NumberFormatException e) {
			throw new CastException("Cannot cast String \""+string+"\" to Integer");
		}
	}
}
