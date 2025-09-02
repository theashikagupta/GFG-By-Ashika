class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] ps=new int[26];
        int[] ss=new int[26];
        if(p.length()>s.length()){
            return new ArrayList<>();
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<p.length();i++){
            ps[p.charAt(i)-'a']++;
            ss[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(ps,ss)==true){
            ans.add(0);
        }
        for(int i=p.length();i<s.length();i++){
            ss[s.charAt(i)-'a']++;
            ss[s.charAt(i - p.length()) - 'a']--;
            if(Arrays.equals(ps,ss)==true){
                ans.add(i-p.length()+1);
            }
        }
        return ans;
    }
}
