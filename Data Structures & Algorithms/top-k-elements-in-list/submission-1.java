class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();

        for (int num : nums) {
            int frequency = frequencies.getOrDefault(num, 0);
            frequencies.put(num, ++frequency);
        }

        PriorityQueue<int[]> sortedFrequencies = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            int[] frequency = {entry.getKey(), entry.getValue()};
            if (sortedFrequencies.size() < k) {
                sortedFrequencies.offer(frequency);
                continue;
            }
            if (sortedFrequencies.peek()[1] < frequency[1]) {
                sortedFrequencies.poll();
                sortedFrequencies.offer(frequency);
            }
        }

        int[] result = new int[k];
        int idx = 0;
        for (int[] frequency : sortedFrequencies) {
            result[idx++] = frequency[0];
        }

        return result;
    }
}
