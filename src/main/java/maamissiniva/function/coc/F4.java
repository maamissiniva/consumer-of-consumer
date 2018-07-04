package maamissiniva.function.coc;

/**
 * Four argument function.
 * 
 * @author vrd
 *
 * @param <A> type of function first argument
 * @param <B> type of function second argument
 * @param <C> type of function third argument
 * @param <D> type of function fourth argument
 * @param <E> type of function return value
 */
public interface F4<A,B,C,D,E> {

    E apply(A a, B b, C c, D d);
    
    default FT4<A,B,C,D,E> ft() {
        return t -> apply(t.a,t.b,t.c,t.d);
    }
    
}
