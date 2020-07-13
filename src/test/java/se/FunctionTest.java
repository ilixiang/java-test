package se;

import org.junit.Test;

import java.util.function.Predicate;

public class FunctionTest {
    @Test
    public void funcTest() {
        Predicate<Integer> predicate = Predicate.isEqual(0);
    }
}
