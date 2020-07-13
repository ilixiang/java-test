package entity;

import com.google.common.collect.ComparisonChain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Person implements Comparable<Person> {
    private String name;
    private Integer age;

    @Override
    public int compareTo(Person person) {
        return ComparisonChain.start()
                .compare(this.name, person.name)
                .compare(this.age, person.age)
                .result();
    }
}
