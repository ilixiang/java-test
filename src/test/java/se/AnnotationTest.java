package se;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnnotationTest {
    @Test
    public void inheritedTest() throws NoSuchMethodException {
        assertThat(Hello.class.getMethod("sayHello").isAnnotationPresent(Fun.class)).isEqualTo(true);
        assertThat(Hello.class.isAnnotationPresent(Fun.class)).isEqualTo(true);
        assertThat(HelloWorld.class.isAnnotationPresent(Fun.class)).isEqualTo(true);
        assertThat(HelloWorld.class.getMethod("sayHello").isAnnotationPresent(Fun.class)).isEqualTo(true);
    }
}
