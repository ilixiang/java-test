package guava;

import com.google.common.collect.*;
import org.junit.Test;

public class ImmutableCollectionTest {
    @Test
    public void testImmutableList() {
        ImmutableList<Integer> ofList = ImmutableList.of(1, 2, 3);
        ImmutableList<Integer> copyOfList = ImmutableList.copyOf(ofList);
        ImmutableList<Integer> buildList = ImmutableList.<Integer>builder().add(1).add(2).add(3).build();
    }

    @Test
    public void testImmutableSet() {
        ImmutableSortedSet<Integer> sortedSet = ImmutableSortedSet.of(3, 2, 1);
        ImmutableSet<Integer> set = ImmutableSet.of(1, 2, 3);
    }

    @Test
    public void testImmutableMap() {
        ImmutableMap<Integer, String> map = ImmutableMap.<Integer, String>builder().put(1, "1").build();
        ImmutableSortedMap<Integer, String> sortedMap = ImmutableSortedMap.<Integer, String>naturalOrder().put(1, "1").build();
    }

@Test
public void testAsList() {
    ImmutableSortedSet<Integer> sortedSet = ImmutableSortedSet.of(3, 2, 1);
    ImmutableSortedMap<Integer, String> sortedMap = ImmutableSortedMap.<Integer, String>naturalOrder()
            .put(1, "1").put(2, "2").put(3, "3").build();
    System.out.println(sortedMap.entrySet().asList().get(1));
    System.out.println(sortedSet.asList().get(2));
}
}
