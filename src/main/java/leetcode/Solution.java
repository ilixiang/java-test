package leetcode;

import java.util.*;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        if(Objects.isNull(nums)) return null;

        int[] result = new int[2];
        Map<Integer, Integer> numMap = new HashMap();
        for(int i = 0; i < nums.length; ++i) {
            int diff = target - nums[i];
            if(numMap.containsKey(diff)) {
                result[1] = i;
                result[0] = numMap.get(diff);
                break;
                }
            numMap.put(nums[i], i);
        }

        return result;
    }

    public static boolean regularExpressionMatching(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();

        boolean firstMatch = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        if(p.length() >= 2 && p.charAt(1) =='*') {
            // why not call regularExpressionMatching(s.substring(1), p.substring(2))
            return (firstMatch && (regularExpressionMatching(s.substring(1), p)) ||
                            regularExpressionMatching(s, p.substring(2)));
        }else{
            return firstMatch && regularExpressionMatching(s.substring(1), p.substring(1));
        }
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = (right - left) * Math.min(height[left], height[right]);
        while(left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if(height[left] > height[right])
                --right;
            else
                ++left;
        }
        return maxArea;
    }

    public static String intToRoman(int num) {
        Map<Integer, String> intRomanMap = new HashMap<>();
        intRomanMap.put(1, "I");
        intRomanMap.put(4, "IV");
        intRomanMap.put(5, "V");
        intRomanMap.put(9, "IX");
        intRomanMap.put(10, "X");
        intRomanMap.put(40, "XL");
        intRomanMap.put(50, "L");
        intRomanMap.put(90, "XC");
        intRomanMap.put(100, "C");
        intRomanMap.put(400, "CD");
        intRomanMap.put(500, "D");
        intRomanMap.put(900, "CM");
        intRomanMap.put(1000, "M");

        int weight = 1;
        int currentNum = 0;
        StringBuilder romanBuilder = new StringBuilder();
        Stack<Integer> romanStack = new Stack<>();
        while(num != 0) {
            currentNum = num % (10 * weight);
            if(intRomanMap.containsKey(currentNum)) {
                romanStack.push(currentNum);
            } else if(currentNum / weight > 5) {
                int lessThanFive = currentNum - 5 * weight;
                for(int i = 0; i < lessThanFive / weight; ++i) {
                    romanStack.push(weight);
                }
                romanStack.push(5 * weight);
            } else {
                for(int i = 0; i < currentNum / weight; ++i) {
                    romanStack.push(weight);
                }
            }
            num -= currentNum;
            weight *= 10;
        }

        while(romanStack.empty() == false) {
            romanBuilder.append(intRomanMap.get(romanStack.pop()));
        }

        return romanBuilder.toString();
    }

    public static int romanToInt(String s) {
        Map<String, Integer> romanIntMap = new HashMap<>();
        romanIntMap.put("I", 1);
        romanIntMap.put("IV", 4);
        romanIntMap.put("V", 5);
        romanIntMap.put("IX", 9);
        romanIntMap.put("X", 10);
        romanIntMap.put("XL", 40);
        romanIntMap.put("L", 50);
        romanIntMap.put("XC", 90);
        romanIntMap.put("C", 100);
        romanIntMap.put("CD", 400);
        romanIntMap.put("D", 500);
        romanIntMap.put("CM", 900);
        romanIntMap.put("M", 1000);

        int currentIndex = 0;
        int result = 0;
        while(currentIndex < s.length()) {
            if(currentIndex + 1 < s.length() && romanIntMap.containsKey(s.substring(currentIndex, currentIndex + 2))) {
                result += romanIntMap.get(s.substring(currentIndex, currentIndex + 2));
                currentIndex += 2;
            } else {
                result += romanIntMap.get(s.substring(currentIndex, currentIndex + 1));
                currentIndex += 1;
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) return Collections.emptyList();

        for(int left= 0; left < nums.length - 2; ++left) {
            if(left > 0 && nums[left] == nums[left - 1]) continue;
            int mid = left + 1;
            int right = nums.length - 1;
            int negateNum = Math.negateExact(nums[left]);
            while(right > mid) {
                if(nums[mid] + nums[right] < negateNum) ++mid;
                else if(nums[mid] + nums[right] > negateNum) --right;
                else {
                    result.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    ++mid;
                    --right;
                    while(mid < right && nums[mid] == nums[mid - 1] && nums[right] == nums[right + 1]) {
                        ++mid;
                        --right;
                    }
                }

            }
        }
        return result;
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        StringBuilder stringBuilder = new StringBuilder();
        String firstStr = strs[0];

        for(int i = 0; i < firstStr.length(); ++i) {
            for(String str : strs) {
                if(str.length() <= i || str.charAt(i) != firstStr.charAt(i)) return stringBuilder.toString();
            }
            stringBuilder.append(firstStr.charAt(i));
        }

        return stringBuilder.toString();
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];

        ListNode mergedList = mergeLists(lists[0], lists[1]);
        for(int i = 2; i < lists.length; ++i) {
            mergedList = mergeLists(mergedList, lists[i]);
        }

        return mergedList;
    }

    private static ListNode mergeLists(ListNode listOne, ListNode listTwo) {
        if(Objects.isNull(listOne)) return listTwo;
        if(Objects.isNull(listTwo)) return listOne;

        ListNode nodeOne = listOne;
        ListNode nodeTwo = listTwo;

        ListNode resultList = new ListNode();
        ListNode resultCurrentNode = resultList;

        while(Objects.nonNull(nodeOne) && Objects.nonNull(nodeTwo)) {
            ListNode currentNode = null;
            if(nodeOne.val > nodeTwo.val) {
                currentNode = nodeTwo;
                nodeTwo = nodeTwo.next;
            } else {
                currentNode = nodeOne;
                nodeOne = nodeOne.next;
            }
            resultCurrentNode.next = currentNode;
            resultCurrentNode = resultCurrentNode.next;
        }

        resultCurrentNode.next = Objects.isNull(nodeOne) ? nodeTwo : nodeOne;
        return resultList.next;
    }

    public static double myPow(double x, int n) {
        Stack<Integer> stack = new Stack<>();
        double result = 1;
        double tmp = 1;
        while(n != 0) {
            stack.push(n & 1);
            n /= 2;
        }

        while(stack.empty() == false) {
            int i = stack.pop();
            if(i == 1) {

            }
        }

        return result;
    }

}
