package ContainerWithMostWater;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max, i, j;
        max = i = 0;
        j = height.length - 1;
        int dis = j;
        while (i < j) {
            int temp_w = Math.min(height[i], height[j]) * dis;
            if (temp_w >= max) {
                max = temp_w;
            }
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
            dis--;
        }
        return max;
    }
}
