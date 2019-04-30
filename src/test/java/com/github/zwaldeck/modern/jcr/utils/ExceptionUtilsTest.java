package com.github.zwaldeck.modern.jcr.utils;

import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class ExceptionUtilsTest {

    private static void throwException() throws Exception {
        throw new Exception("some checked exception");
    }

    private static Optional throwExceptionInsteadOfReturningOptional() throws Exception {
        throw new Exception("some checked exception");
    }

    private static Object throwExceptionInsteadOfReturning() throws Exception {
        throw new Exception("some checked exception");
    }

    @Test
    public void ignoreConsumerException() {
        Arrays.asList("one", "two", "three").forEach(ExceptionUtils.ignoreExceptionInConsumer(e -> throwException(), Exception.class));
    }

    @Test(expected = RuntimeException.class)
    public void wrapConsumerException() {
        Arrays.asList("one", "two", "three").forEach(ExceptionUtils.wrapExceptionInConsumer(e -> throwException()));
    }

    @Test
    public void ignoreFunctionExceptionUsingOptional() {
        Arrays.asList("one", "two", "three").stream()
                .map(ExceptionUtils.ignoreExceptionInFunctionReturningOptional(e -> throwExceptionInsteadOfReturningOptional(), Exception.class))
                .peek(e -> Assert.assertFalse(e.isPresent()))
                .collect(Collectors.toList());
    }

    @Test
    public void ignoreFunctionException() {
        Arrays.asList("one", "two", "three").stream()
                .map(ExceptionUtils.ignoreExceptionInFunction(e -> throwExceptionInsteadOfReturning(), Exception.class))
                .peek(e -> Assert.assertNull(e))
                .collect(Collectors.toList());
    }

    @Test(expected = RuntimeException.class)
    public void wrapFunctionException() {
        Arrays.asList("one", "two", "three").stream()
                .map(ExceptionUtils.wrapExceptionInFunction(e -> throwExceptionInsteadOfReturning()))
                .collect(Collectors.toList());
    }
}
