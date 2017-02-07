package org.ababup1192.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.BiPredicate;

public class ListUtil {
    public static <T> boolean any(
            Collection<T> c1, Collection<T> c2, BiPredicate<T, T> p) {
        Iterator<T> it = c2.iterator();
        return c1.stream().allMatch(x -> !it.hasNext() || p.test(x, it.next()));
    }
}
