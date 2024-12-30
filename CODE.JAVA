public class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                return mid;  // Target found, return its index
            } else if (nums[mid] < target) {
                low = mid + 1;  // Search the right half
            } else {
                high = mid - 1;  // Search the left half
            }
        }
        
        // If target is not found, 'low' is the index where it should be inserted
        return low;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1:
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        System.out.println(solution.searchInsert(nums1, target1));  // Output: 2
        
        // Test Case 2:
        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        System.out.println(solution.searchInsert(nums2, target2));  // Output: 1
        
        // Test Case 3:
        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        System.out.println(solution.searchInsert(nums3, target3));  // Output: 4
    }
}
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        
        // Find the first position of the target
        result[0] = findFirstPosition(nums, target);
        
        // If the target is not found, return [-1, -1]
        if (result[0] == -1) {
            return result;
        }
        
        // Find the last position of the target
        result[1] = findLastPosition(nums, target);
        
        return result;
    }
    
    private int findFirstPosition(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int firstPos = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                firstPos = mid;
                high = mid - 1; // Continue searching to the left
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return firstPos;
    }
    
    private int findLastPosition(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int lastPos = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                lastPos = mid;
                low = mid + 1; // Continue searching to the right
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return lastPos;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1:
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] result1 = solution.searchRange(nums1, target1);
        System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]");  // Expected: [3, 4]
        
        // Test Case 2:
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = solution.searchRange(nums2, target2);
        System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]");  // Expected: [-1, -1]
        
        // Test Case 3:
        int[] nums3 = {};
        int target3 = 0;
        int[] result3 = solution.searchRange(nums3, target3);
        System.out.println("Output: [" + result3[0] + ", " + result3[1] + "]");  // Expected: [-1, -1]
    }
}
class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Convert both numbers to positive for easier handling
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        int result = 0;
        
        // Perform the division using bit shifting
        while (longDividend >= longDivisor) {
            long tempDivisor = longDivisor, multiple = 1;
            
            // Double the divisor until it exceeds the dividend
            while (longDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }
            
            // Subtract the largest possible multiple of divisor
            longDividend -= tempDivisor;
            result += multiple;
        }

        // Determine the sign of the result
        if ((dividend < 0) ^ (divisor < 0)) {
            result = -result;
        }

        return result;
    }
}
class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Convert both numbers to positive for easier handling
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        int result = 0;
        
        // Perform the division using bit shifting
        while (longDividend >= longDivisor) {
            long tempDivisor = longDivisor, multiple = 1;
            
            // Double the divisor until it exceeds the dividend
            while (longDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }
            
            // Subtract the largest possible multiple of divisor
            longDividend -= tempDivisor;
            result += multiple;
        }

        // Determine the sign of the result
        if ((dividend < 0) ^ (divisor < 0)) {
            result = -result;
        }

        return result;
    }
}
class Solution {
    public int strStr(String haystack, String needle) {
        // Edge case: if needle is an empty string, return 0
        if (needle.isEmpty()) {
            return 0;
        }
        
        int n = haystack.length();
        int m = needle.length();
        
        // If haystack is shorter than needle, return -1
        if (n < m) {
            return -1;
        }
        
        // Traverse haystack and check for the first occurrence of needle
        for (int i = 0; i <= n - m; i++) {
            // Compare substring starting at i with needle
            if (haystack.substring(i, i + m).equals(needle)) {
                return i; // Found the first occurrence, return the index
            }
        }
        
        return -1; // If no occurrence found, return -1
    }
}
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0; // Pointer to track the position for non-val elements
        
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j]; // Move the non-val element to the position i
                i++; // Increment i to point to the next available position
            }
        }
        
        return i; // Return the count of non-val elements
    }
}
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int i = 0; // Pointer for the last unique element
        
        // Start from the second element and compare with the last unique element
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++; // Increment the index for unique element
                nums[i] = nums[j]; // Update the next unique element position
            }
        }
        
        return i + 1; // The number of unique elements
    }
}
import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Define a min-heap (priority queue) to store the nodes
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Initialize the heap with the head of each list (if non-null)
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        // Create a dummy node to simplify the merge process
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Process the heap until it's empty
        while (!minHeap.isEmpty()) {
            // Extract the smallest element from the heap
            ListNode node = minHeap.poll();
            current.next = node;  // Link the current node to the merged list
            current = current.next;  // Move the current pointer forward

            // If the extracted node has a next node, add it to the heap
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        // Return the merged list starting from dummy.next
        return dummy.next;
    }
}
import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);  // start with an empty string and no parentheses added
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int n) {
        // Base case: if the current string's length is 2*n, it's a valid combination
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Add an opening parenthesis if we can
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }

        // Add a closing parenthesis if we can
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }
}
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node that acts as the prehead of the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Traverse through both lists and merge them
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;  // Link the smaller node to the merged list
                list1 = list1.next;    // Move the pointer in list1
            } else {
                current.next = list2;  // Link the smaller node to the merged list
                list2 = list2.next;    // Move the pointer in list2
            }
            current = current.next;   // Move the current pointer to the newly added node
        }

        // If one of the lists is not empty, append the rest of the nodes
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Return the merged list, which starts from dummy.next
        return dummy.next;
    }
}
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // Create a stack to keep track of the opening brackets
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // If the character is an opening bracket, push it onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If the character is a closing bracket, check if the stack is empty or mismatched
                if (stack.isEmpty()) {
                    return false; // No corresponding opening bracket
                }
                char top = stack.pop();
                // Check if the popped element matches the correct opening bracket
                if (c == ')' && top != '(' ||
                    c == '}' && top != '{' ||
                    c == ']' && top != '[') {
                    return false; // Mismatched brackets
                }
            }
        }
        
        // If the stack is empty, all opening brackets have been matched
        return stack.isEmpty();
    }
}
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node that points to the head of the list
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Initialize two pointers, both start at the dummy node
        ListNode first = dummy;
        ListNode second = dummy;
        
        // Advance the first pointer by n+1 steps to maintain a gap of n between first and second
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        
        // Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // Remove the nth node from the end by skipping it
        second.next = second.next.next;
        
        // Return the head of the modified list
        return dummy.next;
    }
}
import java.util.*;

public class Solution {
    // Mapping of digits to letters as on a telephone keypad
    private static final String[] MAPPING = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        // If the input string is empty, return an empty list
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        // List to store the result combinations
        List<String> result = new ArrayList<>();
        
        // Start backtracking to generate combinations
        backtrack(digits, 0, new StringBuilder(), result);
        
        return result;
    }

    // Backtracking helper function to generate combinations
    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // If the current combination is of the same length as the digits string, add it to the result
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the current digit and its corresponding letters
        int digit = digits.charAt(index) - '0';
        String letters = MAPPING[digit];
        
        // Try each letter for the current digit
        for (char letter : letters.toCharArray()) {
            current.append(letter);  // Add the letter to the current combination
            backtrack(digits, index + 1, current, result);  // Recurse for the next digit
            current.deleteCharAt(current.length() - 1);  // Backtrack by removing the last added letter
        }
    }
}
import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array to enable two-pointer technique
        Arrays.sort(nums);
        
        // Variable to keep track of the closest sum
        int closestSum = Integer.MAX_VALUE;
        
        // Iterate through the array, considering each element as the first element of the triplet
        for (int i = 0; i < nums.length - 2; i++) {
            // Avoid duplicates for the first element of the triplet
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Set up two pointers
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                // If the sum is exactly equal to the target, return it immediately
                if (sum == target) {
                    return sum;
                }
                
                // If the sum is closer to the target than the previous closest sum, update the closest sum
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
                
                // Move the pointers based on the comparison of sum with target
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        // Return the closest sum found
        return closestSum;
    }
}
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Edge case: If the list is empty, return ""
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Start with the first string as the longest common prefix
        String prefix = strs[0];
        
        // Iterate over the rest of the strings
        for (int i = 1; i < strs.length; i++) {
            // Compare the current prefix with the string character by character
            while (!strs[i].startsWith(prefix)) {
                // Reduce the prefix by one character from the end
                prefix = prefix.substring(0, prefix.length() - 1);
                // If no common prefix exists, return an empty string
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        // Return the longest common prefix found
        return prefix;
    }
}

