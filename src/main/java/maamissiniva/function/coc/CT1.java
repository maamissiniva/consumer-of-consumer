package maamissiniva.function.coc;

public interface CT1<A> extends CC1<T1<A>> {

    default CC1<A> cc() {
        return nc -> accept(t -> nc.accept(t.a));
    }
    
    default <RA> CT1<RA> ct1(F1<A,RA> f) {
        return nc -> accept(t -> nc.accept(new T1<>(f.apply(t.a))));
    }
    
}
