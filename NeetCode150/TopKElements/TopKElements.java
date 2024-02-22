package TopKElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }
        for (int key : freqMap.keySet()) {
            int frequency = freqMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        int[] result = new int[k];
        int counter = 0;
        for (int pos = bucket.length - 1; pos > 0 && counter < k; pos--) {
            if (bucket[pos] != null) {
                for (int j : bucket[pos]) {
                    result[counter++] = j;
                }
            }
        }
        return result;
    }
}
