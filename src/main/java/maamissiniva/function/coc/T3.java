package maamissiniva.function.coc;

public class T3<A,B,C> implements CC1<T3<A,B,C>> {

    public final A a;
    
    public final B b;
    
    public final C c;
    
    public T3(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void accept(C1<T3<A, B, C>> ct) throws Exception {
        ct.accept(this);
    }

    public <D> D map(F3<A,B,C,D> f) {
        return f.apply(a, b, c);
    }
    
}
