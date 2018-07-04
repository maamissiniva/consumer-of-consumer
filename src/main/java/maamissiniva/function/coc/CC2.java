package maamissiniva.function.coc;

public interface CC2<A,B> extends C1<C2<A,B>> {
    
    default <C> CC3<A,B,C> nest(F2<A,B,CC1<C>> f) {
        return nc -> accept((a,b) -> f.apply(a,b).accept(c -> nc.accept(a,b,c)));
    }
    
    default <RA> CC1<RA> cc1(F2<A,B,RA> f) {
        return nc -> accept((a,b) -> nc.accept(f.apply(a, b)));
    }
    
    default CT2<A,B> ct() {
        return nc -> accept((a,b) -> nc.accept(new T2<>(a,b)));
    }
    
//    default <RA,RB> CC2<RA,RB> cc2(F2<A,B,T2<RA,RB>> f) {
//        return nc -> accept((a,b) -> f.apply(a,b).accept(t -> nc.accept(t.a,t.b)));
//    }

    default <RA,RB> CC2<RA,RB> cc2(F2<A,B,T2<RA,RB>> f) {
        return ct().ct2(f.ft()).cc();
    }
    
}
