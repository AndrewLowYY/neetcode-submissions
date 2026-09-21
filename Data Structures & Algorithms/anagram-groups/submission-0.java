class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> store = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String hash = new String(chars);
            List list = store.getOrDefault(hash, new ArrayList<>());
            list.add(str);
            store.put(hash, list);
        }

        return new ArrayList<List<String>>(store.values());
    
    }
}
