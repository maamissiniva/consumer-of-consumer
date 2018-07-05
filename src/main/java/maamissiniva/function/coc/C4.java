package maamissiniva.function.coc;

/**
 * Four value consumer.
 * 
 * @author vrd
 *
 * @param <A> type of first value
 * @param <B> type of second value
 * @param <C> type of third value
 * @param <D> type of fourth value
 */
public interface C4<A,B,C,D> {

    public void accept(A a, B b, C c, D d) throws Exception;
    
}
