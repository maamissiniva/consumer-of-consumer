package maamissiniva.function.coc;

public interface FT2<A,B,C> extends F1<T2<A,B>,C> {

    default F2<A,B,C> f() { 
        return (a,b) -> apply(new T2<>(a,b));
    }
    
}
