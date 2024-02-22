package LongestSubstringWithoutRepeatingCharacter;

import java.util.HashMap;

public class LongestSubstringWithoutSubstring {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0;
        int right = 0;
        int len = 0;
        int n = s.length();
        while (right < n) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            map.put(s.charAt(right), right);
            len = Math.max(right - left + 1, len);
            right++;
        }
        return len;
    }
}
