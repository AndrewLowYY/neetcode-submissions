class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        for (int num : nums) {
            set.add(num);
        }

        for (Integer num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int length = 1;
            while (set.contains(num + length)) {
                length++;
            }
            longest = Math.max(longest,length);
        }
        return longest;
    }
}
