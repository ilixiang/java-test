package se;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InstanceOfTest {
    @Test
    public void instanceOfTest() {
        HelloWorld helloWorld = new HelloWorld();
        assertThat(helloWorld instanceof HelloWorld).isEqualTo(true);
        assertThat(helloWorld instanceof Hello).isEqualTo(true);
    }
}
