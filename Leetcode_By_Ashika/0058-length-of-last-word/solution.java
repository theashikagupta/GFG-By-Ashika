class Solution {
    public int lengthOfLastWord(String s) {
        String str1=s.trim();
        String[] words=str1.split(" ");
        String last_word=words[words.length-1];
        return last_word.length();
    }
}
