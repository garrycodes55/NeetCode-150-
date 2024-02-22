package PermutationsInString;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26]; // Assuming only lowercase letters
        int n1 = s1.length(), n2 = s2.length();

        // Count the frequency of characters in s1
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        int left = 0, right = 0;
        while (right < n2) {
            // Include the character at the right pointer
            count[s2.charAt(right) - 'a']--;

            // Check if the window size matches s1
            while (right - left + 1 == n1) {
                if (allZeros(count)) {
                    return true;
                }
                count[s2.charAt(left) - 'a']++; // Exclude the leftmost character
                left++;
            }

            right++;
        }
        return false;
    }
    private boolean allZeros(int[] count) {
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
