package maamissiniva.function.coc;

/**
 * Three argument function.
 * 
 * @author vrd
 *
 * @param <A> type of function first argument 
 * @param <B> type of function second argument
 * @param <C> type of function third argument
 * @param <D> type of function return value
 */
public interface F3<A,B,C,D> {

    D apply(A a, B b, C c);
    
    default FT3<A,B,C,D> ft() {
        return t -> apply(t.a,t.b,t.c);
    }
    
}
