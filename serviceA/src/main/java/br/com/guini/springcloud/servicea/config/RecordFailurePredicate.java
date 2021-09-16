package br.com.guini.springcloud.servicea.config;

import java.util.function.Predicate;

public class RecordFailurePredicate implements Predicate<RuntimeException> {
    @Override
    public boolean test(RuntimeException e) {
        return true;
    }
}
