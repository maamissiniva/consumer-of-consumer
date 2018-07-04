package maamissiniva.function.coc;

public interface CC4<A,B,C,D> extends C1<C4<A,B,C,D>> {
    
    default <RA> CC1<RA> cc1(F4<A,B,C,D,RA> f) {
        return nc -> accept((a,b,c,d) -> nc.accept(f.apply(a, b, c, d)));
    }
    
    default <RA,RB> CT2<RA,RB> ct2(F4<A,B,C,D,T2<RA,RB>> f) {
        return nc -> accept((a,b,c,d) -> nc.accept(f.apply(a, b, c, d))); 
    }
    
    default <RA,RB> CC2<RA,RB> cc2(F4<A,B,C,D,T2<RA,RB>> f) {
        return nc -> accept((a,b,c,d) -> f.apply(a, b, c, d).accept(t -> nc.accept(t.a, t.b))); 
    }
    
    default <RA,RB,RC> CC3<RA,RB,RC> cc3(F4<A,B,C,D,T3<RA,RB,RC>> f) {
        return nc -> accept((a,b,c,d) -> f.apply(a, b, c, d).accept(t -> nc.accept(t.a, t.b, t.c)));
    }

    default <RA,RB,RC,RD> CC4<RA,RB,RC,RD> cc4(F4<A,B,C,D,T4<RA,RB,RC,RD>> f) {
        return nc -> accept((a,b,c,d) -> f.apply(a, b, c, d).accept(t -> nc.accept(t.a, t.b, t.c, t.d)));
    }

}
