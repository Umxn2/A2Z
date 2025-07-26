class Solution {

    public String longestCommonPrefix(String[] strs) {
        int len = strs.length();
        int[] indexes = new int[len];
        String result = "";
        int index = 0;
        outer: while (true) {
            if (index >= strs[0].length()) break;
            char currChar = strs[0].charAt(index);
            for (int i = 0; i < indexes.length; i++) {
                if (index >= strs[i].length()) break;
                if (strs[i].charAt(index) != currChar) {
                    break outer;
                }
            }
            result = result.concat(currChar);
            index++;
        }
        return result;
    }
}
