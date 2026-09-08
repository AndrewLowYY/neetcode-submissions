class Solution {
    public boolean isAnagram(String s, String t) {
        int[] store = new int[26];

        for (char c : s.toCharArray()) {
            store[c - 'a']++;
        }
        
        for (char c : t.toCharArray()) {
            store[c - 'a']--;
        }

        for (int i : store) {
            if (i != 0) return false;
        }
        return true;
    }
}
