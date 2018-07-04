package maamissiniva.function.coc;

public interface CT3<A,B,C> extends CC1<T3<A,B,C>> {

    default CC3<A,B,C> cc() {
        return nc -> accept(t -> nc.accept(t.a, t.b, t.c));
    }
    
    default <RA,RB> CT2<RA,RB> ct2(F1<T3<A,B,C>,T2<RA,RB>> ff) {
        return nc -> accept(t -> nc.accept(ff.apply(t)));
    }
    
    default <RA,RB,RC> CT3<RA,RB,RC> ct3(F1<T3<A,B,C>,T3<RA,RB,RC>> ff) {
        return nc -> accept(t -> nc.accept(ff.apply(t)));
    }
    
}
