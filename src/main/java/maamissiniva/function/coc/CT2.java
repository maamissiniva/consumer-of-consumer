package maamissiniva.function.coc;

public interface CT2<A,B> extends CC1<T2<A,B>> {

    default CC2<A,B> cc() {
        return nc -> accept(t -> nc.accept(t.a, t.b));
    }
    
    default <RA> CT1<RA> ct1(F1<T2<A,B>,T1<RA>> ff) {
        return nc -> accept(t -> nc.accept(ff.apply(t)));
    }
    
    default <RA,RB> CT2<RA,RB> ct2(F1<T2<A,B>,T2<RA,RB>> ff) {
        return nc -> accept(t -> nc.accept(ff.apply(t)));
    }
    
}
