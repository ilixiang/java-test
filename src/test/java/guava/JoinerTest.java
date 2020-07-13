package guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JoinerTest {
    @Test
    public void joinerTest() {
        List<String> list = Arrays.asList(
                "Google", "Guava", "is", "the", "best"
        );
        String joinString = Joiner.on("#").useForNull("233").join(list);
        List<String> splitList = Splitter.on("#").splitToList(joinString);
        assertThat(joinString).as("check string").isEqualTo("Google#Guava#is#the#best").contains(list);
        assertThat(splitList).containsExactly("Google", "Guava", "is", "the", "best");
    }
}
