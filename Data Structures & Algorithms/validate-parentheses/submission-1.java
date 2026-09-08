class Solution {
    public boolean isValid(String s) {

        Set<Character> openingChars = Set.of('[', '{', '(');

        Map<Character, Character> matchingPairs = 
            Map.ofEntries(
                Map.entry(']', '['),
                Map.entry('}', '{'),
                Map.entry(')', '(')
                );

        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (openingChars.contains(c)) {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty() || !stack.pop().equals(matchingPairs.get(c))) {
                return false;
            }

        }

        return stack.isEmpty();
    }
}
