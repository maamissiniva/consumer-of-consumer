package maamissiniva.function.coc;

public interface CC3<A,B,C> extends C1<C3<A,B,C>> {

    default <RA> CC1<RA> cc1(F3<A,B,C,RA> f) {
        return nc -> accept((a,b,c) -> nc.accept(f.apply(a, b, c)));
    }
    
//    default <RA,RB> CC2<RA,RB> cc2(F3<A,B,C,T2<RA,RB>> f) {
//        return nc -> accept((a,b,c) -> f.apply(a, b, c).accept(t -> nc.accept(t.a, t.b))); 
//    }
//    
//    default <RA,RB,RC> CC3<RA,RB,RC> cc3(F3<A,B,C,T3<RA,RB,RC>> f) {
//        return nc -> accept((a,b,c) -> f.apply(a, b, c).accept(t -> nc.accept(t.a, t.b, t.c)));
//    }

    default <RA,RB> CC2<RA,RB> cc2(F3<A,B,C,T2<RA,RB>> ff) {
        return ct().ct2(ff.ft()).cc();
    }
    
    default <RA,RB,RC> CC3<RA,RB,RC> cc3(F3<A,B,C,T3<RA,RB,RC>> ff) {
        return ct().ct3(ff.ft()).cc();
    }    
    
    default CT3<A,B,C> ct() {
        return nc -> accept((a,b,c) -> nc.accept(new T3<>(a,b,c)));
    }
    
    default <D> CC4<A,B,C,D> nest(F3<A,B,C,CC1<D>> f) {
        return nc -> accept((a,b,c) -> f.apply(a, b, c).accept(d -> nc.accept(a, b, c, d)));
    }
    
}
