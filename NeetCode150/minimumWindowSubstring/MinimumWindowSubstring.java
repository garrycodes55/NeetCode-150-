package minimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int n = s.length();
        int left = 0, right = 0;
        int minWindow = Integer.MAX_VALUE;
        int requiredCount = t.length();
        int start_index = 0;

        Map<Character, Integer> map = new HashMap<>();

        if (t.length() > n) {
            return "";
        }
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        while (right < n) {
            if (map.containsKey(s.charAt(right)) && map.get(s.charAt(right)) > 0) {
                requiredCount--;
            }

            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
            }

            while (requiredCount == 0) {
                int currentWindow = right - left + 1;

                if (currentWindow < minWindow) {
                    minWindow = currentWindow;
                    start_index = left;
                }

                if (map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);

                    if (map.get(s.charAt(left)) > 0) {
                        requiredCount++;
                    }
                }
                left++;
            }
            right++;
        }

        return minWindow == Integer.MAX_VALUE ? "" : s.substring(start_index, start_index + minWindow);
    }
}


