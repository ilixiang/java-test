package guava;

import com.google.common.collect.Lists;
import entity.Person;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class OrderingTest {

    @Test
    public void usageTest() {
        List<Person> list = Lists.newArrayList(
                new Person("zhangsan", 13),
                new Person("lisi", 14),
                new Person("xiaoming", 11),
                new Person("lisi", 15)
        );
        Collections.sort(list);
        list.forEach(System.out::println);
    }

}
