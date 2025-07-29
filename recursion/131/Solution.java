import java.util.List;

class Solution {

    public List<List<String>> partition(String s) {}

    void getAllOutputs(
        List<List<String>> output,
        String currString,
        int index,
        String s,
        List<String> currList
    ) {
        if(index == s.length()){
            if(isPalindrome(currString)){
                
            }
        }
        for (int i = index; i < s.length(); i++) {
            // either stop here and put the flag or keep going
            getAllOutputs(
                output,
                currString + s.charAt(index),
                index + 1,
                s,
                currList
            );
            // stop here
            if (isPalindrome(currString)) {
                currList.add(new String(currString));
                getAllOutputs(output, "", index + 1, s, currList);
                currList.remove(currList.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!(s.charAt(i) == s.charAt(s.length() - i))) return false;
        }
        return true;
    }
}
