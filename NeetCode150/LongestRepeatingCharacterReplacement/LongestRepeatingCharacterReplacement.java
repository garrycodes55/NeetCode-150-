package LongestRepeatingCharacterReplacement;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int max_count = 0;
        int n = s.length();
        int[] count = new int[26];
        for (right = 0; right < n; right++) {
            count[s.charAt(right) - 'A']++;
            max_count = Math.max(max_count, count[s.charAt(right) - 'A']);
            while (right - left + 1 - max_count > k) {
                count[s.charAt(right) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

}
