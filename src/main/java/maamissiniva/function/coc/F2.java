package maamissiniva.function.coc;

/**
 * Bifunction.
 *  
 * @author vrd
 *
 * @param <A> type of function first argument
 * @param <B> type of function second argument
 * @param <C> type of function return value 
 */
public interface F2<A,B,C> {

    C apply(A a, B b);
    
    default FT2<A,B,C> ft() {
        return t -> apply(t.a,t.b);
    }
    
}
