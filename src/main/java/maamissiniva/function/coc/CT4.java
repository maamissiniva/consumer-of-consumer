package maamissiniva.function.coc;

public interface CT4<A,B,C,D> extends CC1<T4<A,B,C,D>> {

    default CC4<A,B,C,D> cc() {
        return nc -> accept(t -> nc.accept(t.a,t.b,t.c,t.d));
    }
    
    default <RA,RB> CT2<RA,RB> ct2(F1<T4<A,B,C,D>,T2<RA,RB>> ff) {
        return nc -> accept(t -> nc.accept(ff.apply(t)));
    }
    
    default <RA,RB,RC> CT3<RA,RB,RC> ct3(F1<T4<A,B,C,D>,T3<RA,RB,RC>> ff) {
        return nc -> accept(t -> nc.accept(ff.apply(t)));
    }
    
    default <RA,RB,RC,RD> CT4<RA,RB,RC,RD> ct4(F1<T4<A,B,C,D>,T4<RA,RB,RC,RD>> ff) {
        return nc -> accept(t -> nc.accept(ff.apply(t)));
    }
    
}
