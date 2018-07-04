package maamissiniva.function.coc;

public class T1<A> implements CT1<A> {
    
    public final A a;
    
    public T1(A a) {
        this.a = a;
    }

    @Override
    public void accept(C1<T1<A>> c) throws Exception {
        c.accept(this);
    }
    
}
