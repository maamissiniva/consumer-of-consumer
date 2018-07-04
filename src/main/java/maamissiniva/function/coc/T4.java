package maamissiniva.function.coc;

public class T4<A,B,C,D> implements CT4<A,B,C,D> {

    public final A a;
    public final B b;
    public final C c;
    public final D d;
    
    public T4(A a, B b, C c, D d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public void accept(C1<T4<A, B, C, D>> cc) throws Exception {
        cc.accept(this);
    }
    
}
