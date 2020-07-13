package se;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GenericTest {

    enum LifeCircle{ ANNUAL, PERENNIAL, BIENNIAL };

    @Test
    public void wildcardTypeTest() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
    }

    private void process(List<? extends CharSequence> list) {
        for(CharSequence item: list) {
            System.out.println(item);
        }
    }
}

