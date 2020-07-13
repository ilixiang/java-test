package guava;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RangeTest {
    @Test
    public void testBasic() {
        Range<Integer> range = Range.closed(0, 10);
        assertThat(range.containsAll(Arrays.asList(1, 2, 3))).isTrue();
    }

    @Test
    public void testRangeSet() {
    }
}
