package maamissiniva.function.coc;

public interface FT4<A,B,C,D,E> extends F1<T4<A,B,C,D>,E> {

    default F4<A,B,C,D,E> f4() {
        return (a,b,c,d) -> apply(new T4<>(a,b,c,d));
    }
    
}
