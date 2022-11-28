package maamissiniva.function.coc;

/**
 * Consumer of consumer of two arguments.
 * 
 * @author vrd
 *
 * @param <A> first argument type
 * @param <B> second argument type
 */
public interface CC2<A,B> extends C1<C2<A,B>> {
    
    /**
     * Combine with a CC1 constructor.
     * @param <C> third value type
     * @param f CC1 constructor
     * @return  CC3
     */
    default <C> CC3<A,B,C> nest(F2<A,B,CC1<C>> f) {
        return nc -> accept((a,b) -> f.apply(a,b).accept(c -> nc.accept(a,b,c)));
    }
    
    
    /**
     * Combine with a CC2 constructor.
     * @param <C> third value type
     * @param <D> fourth value type
     * @param f CC2 constructor.
     * @return  CC4
     */
    default <C,D> CC4<A,B,C,D> nest2(F2<A,B,CC2<C,D>> f) {
        return nc -> accept((a,b) -> f.apply(a,b).accept((c,d) -> nc.accept(a,b,c,d)));
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
