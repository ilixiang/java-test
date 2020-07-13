import entity.Person;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LombokTest {
    @Test
    public void builderTest() {
        Person person = Person.builder().age(10).name("richard").build();
        assertThat(person.getAge()).isEqualTo(10);
        assertThat(person.getName()).isEqualTo("richard");
    }

    @Test
    public void toStringTest() {
        Person person = Person.builder().age(10).name("richard").build();
        System.out.println(person);
    }
}
