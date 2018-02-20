package twoPointers;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;

        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !valid(s.charAt(i))) i++;
            while (i < j && !valid(s.charAt(j))) j--;
            System.out.println(i);
            System.out.println(j);

            if (s.charAt(i) != s.charAt(j) && ((s.charAt(i) >= 97 || s.charAt(j) >= 97) &&(Math.abs(s.charAt(i) - s.charAt(j)) == 32))) return false;
        }

        return true;
    }

    private boolean valid(char c) {
        return c >= 65 && c <= 90 || c >= 97 && c <= 122 || c >= 48 && c <= 57;
    }

    public boolean isPalindrome1(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }
}
