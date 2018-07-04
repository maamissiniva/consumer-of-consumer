package maamissiniva.function.coc;

/**
 * Three value consumer.
 * 
 * @author vrd
 *
 * @param <A> type of first value
 * @param <B> type of second value
 * @param <C> type of third value
 */
public interface C3<A,B,C> {

    void accept(A a, B b, C c) throws Exception;
    
}
