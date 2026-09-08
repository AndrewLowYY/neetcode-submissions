class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c))
                sb.append(Character.toLowerCase(c));
        }

        s = sb.toString();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < s.length() - 1) left++;
            while (!Character.isLetterOrDigit(s.charAt(right)) && right > 0) right--;
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
