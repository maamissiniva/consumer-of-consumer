package maamissiniva.function.coc;

/**
 * BiConsumer.
 * 
 * @author vrd
 *
 * @param <A> first value type
 * @param <B> second value type
 */
public interface C2<A,B> {
    
    void accept(A a, B b) throws Exception;
    
}
