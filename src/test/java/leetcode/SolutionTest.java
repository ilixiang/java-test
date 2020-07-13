package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    @Test
    public void twoSumTest() {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] res = Solution.twoSum(arr, target);
        assertThat(res).describedAs("Two sum example test").containsExactly(0, 1);
    }

    @Test
    public void regularExpressionMatchingTest() {
        Assertions.assertThat(Solution.regularExpressionMatching("aa", "a")).isFalse();
        Assertions.assertThat(Solution.regularExpressionMatching("aa", "a*")).isTrue();
        Assertions.assertThat(Solution.regularExpressionMatching("ab", ".*")).isTrue();
        Assertions.assertThat(Solution.regularExpressionMatching("aab", "c*a*b*")).isTrue();
        Assertions.assertThat(Solution.regularExpressionMatching("mississippi", "mis*is*p*.")).isFalse();
        Assertions.assertThat(Solution.regularExpressionMatching("aaa", "a*aa")).isTrue();
    }

    @Test
    public void maxAreaTest() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        Assertions.assertThat(Solution.maxArea(height)).isEqualTo(49);
    }

    @Test
    public void intToRomanTest() {
        Assertions.assertThat(Solution.intToRoman(3)).isEqualTo("III");
        Assertions.assertThat(Solution.intToRoman(4)).isEqualTo("IV");
        Assertions.assertThat(Solution.intToRoman(9)).isEqualTo("IX");
        Assertions.assertThat(Solution.intToRoman(58)).isEqualTo("LVIII");
        Assertions.assertThat(Solution.intToRoman(1994)).isEqualTo("MCMXCIV");
    }

    @Test
    public void romanToIntTest() {
        Assertions.assertThat(Solution.romanToInt("III")).isEqualTo(3);
        Assertions.assertThat(Solution.romanToInt("IV")).isEqualTo(4);
        Assertions.assertThat(Solution.romanToInt("IX")).isEqualTo(9);
        Assertions.assertThat(Solution.romanToInt("LVIII")).isEqualTo(58);
        Assertions.assertThat(Solution.romanToInt("MCMXCIV")).isEqualTo(1994);
    }

    @Test
    public void threeSumTest() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] numsTwo = {1, -1, -1, 0};
        Assertions.assertThat(Solution.threeSum(nums)).contains(Arrays.asList(-1, 0, 1)).contains(Arrays.asList(-1, -1, 2));
        Assertions.assertThat(Solution.threeSum(numsTwo)).contains(Arrays.asList(-1, 0, 1));
    }

    @Test
    public void longestCommonPrefixTest() {
        String[] strsOne = {"flower","flow","flight"};
        String[] strsTwo = {"dog","racecar","car"};

        Assertions.assertThat(Solution.longestCommonPrefix(strsOne)).isEqualTo("fl");
        Assertions.assertThat(Solution.longestCommonPrefix(strsTwo)).isEqualTo("");
    }

    @Test
    public void mergeKListsTest() {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        lists[2] = new ListNode(2, new ListNode(6, null));

        ListNode resultList = Solution.mergeKLists(lists);
        int[] resultVals = {1, 1, 2, 3, 4, 4, 5, 6};
        int i = 0;
        while(resultList != null) {
            Assertions.assertThat(resultList.val).isEqualTo(resultVals[i]);
            ++i;
            resultList = resultList.next;
        }
    }

}
