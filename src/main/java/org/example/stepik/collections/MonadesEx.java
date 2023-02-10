package org.example.stepik.collections;

import java.util.function.Function;

public class MonadesEx {

    /**
     * A parametrized type Monad<T>
     */
    interface Monad<T> {

        /**
         * Takes a value T and returns Monad<T> wrapping the value
         */
        Monad<T> unit(T value);

        /**
         * Takes a function f: T -> U and returns a Monad<U>
         * May be defined as a combination of unit and bind
         */
        <U> Monad<U> map(Function<? super T, ? extends U> f);

        /**
         * Takes a function f: T -> Monad<U> and returns a Monad<U>
         */
        <U> Monad<U> flatMap(Function<? super T, Monad<U>> f);

        /**
         * Returns the value back to the world
         */
        T get();
    }
}
