package maamissiniva.function.coc;

import java.util.Objects;

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

    @Override
	public boolean equals(Object o) {
    	if (! (o instanceof T2))
    		return false;
    	T2<?,?> t = (T2<?,?>)o;
    	return Objects.equals(a, t.a)
    		&& Objects.equals(b, t.b);
    }
    
    @Override
    public int hashCode() {
    	return Objects.hash(a, b);
    }
    
    @Override
	public String toString() {
    	return "(" + a + "," + b + ")";
    }
    
}
