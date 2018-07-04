package maamissiniva.function.coc;

public interface FT3<A,B,C,D> extends F1<T3<A,B,C>,D> {

    default F3<A,B,C,D> f() {
        return (a,b,c) -> apply(new T3<>(a,b,c));
    }
    
}
