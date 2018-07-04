package maamissiniva.function.coc;

public interface CT4<A,B,C,D> extends CC1<T4<A,B,C,D>> {

    default CC4<A,B,C,D> cc() {
        return nc -> accept(t -> nc.accept(t.a,t.b,t.c,t.d));
    }
    
}
