package Cast;


public interface ICastHandler{

	<TIn> Object cast(TIn inValue, Class<?> inClass, Class<?> outClass) throws CastException;

}
