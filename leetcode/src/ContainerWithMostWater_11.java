public class ContainerWithMostWater_11 {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        var water = maxArea(height);
        System.out.println(water);
    }

    // two pointers
    public static int maxArea(int[] height) {
        int maxWater = 0;
        int p1 = 0;
        int p2 = height.length - 1;

        while (p1 < p2) {
            var water = Math.min(height[p1], height[p2]) * Math.abs(p2 - p1);
            maxWater = Math.max(maxWater, water);

            // if p1 height is smaller, try to find a bigger one -> move p1
            if (height[p1] < height[p2]) {
                p1++;
            } else {
                p2--;
            }
        }

        return maxWater;
    }
}
