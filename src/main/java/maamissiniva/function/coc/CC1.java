package maamissiniva.function.coc;

/**
 * Consumer of consumer of one argument.
 * 
 * @author vrd
 *
 * @param <A> consumer first argument type.
 */
public interface CC1<A> extends C1<C1<A>> {
    
    /**
     * Core combination with a CC1.
     * @param f CC1 constructor
     * @return  CC2
     */
    default <B> CC2<A,B> nest(F1<A,CC1<B>> f) {
        return nc -> accept(a -> f.apply(a).accept(b -> nc.accept(a,b))); 
    }
    
    /**
     * Combination with an independent CC1.
     * @param cc CC1
     * @return   CC2
     */
    default <B> CC2<A,B> and(CC1<B> cc) {
        return nest(dummy -> cc);
    }
    
    /**
     * Combination with a a CC1 that looks like the combined CC1.
     * @param f CC1 constructor
     * @return  CC1
     */
    default <B> CC1<B> then(F1<A,CC1<B>> f) {
        return nest(f).cc1((a,b) -> b);
    }
    
    default <B,C> CC3<A,B,C> nest2(F1<A,CC2<B,C>> f) {
        return nc -> accept(a -> f.apply(a).accept((b,c) -> nc.accept(a,b,c)));
    }
    
    default <B,C,D> CC4<A,B,C,D> nest3(F1<A,CC3<B,C,D>> f) {
        return nc -> accept(a -> f.apply(a).accept((b,c,d) -> nc.accept(a,b,c,d)));
    }
    
    default <RA> CC1<RA> cc1(F1<A,RA> f) {
        return nc -> accept(a -> nc.accept(f.apply(a)));
    }
    
    default CT1<A> ct() {
        return nc -> accept(a -> nc.accept(new T1<>(a)));
    }
    
}