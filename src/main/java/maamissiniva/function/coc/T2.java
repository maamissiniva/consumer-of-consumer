package maamissiniva.function.coc;

public class T2<A,B> implements CC1<T2<A,B>> {
    
    public final A a;
    
    public final B b;
    
    public T2(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void accept(C1<T2<A, B>> ct) throws Exception {
        ct.accept(this);
    }

     
}
