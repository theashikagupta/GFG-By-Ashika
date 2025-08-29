class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb=new StringBuilder(s);
        int n=s.length();
        int l=0;
        int r=n-1;
        
        while(l<r){
            if(!isVowel(sb.charAt(l))){
                l++;
            }
            else if(!isVowel(sb.charAt(r))){
                r--;
            }
            else{
                char temp = sb.charAt(l);
                sb.setCharAt(l, sb.charAt(r));
                sb.setCharAt(r, temp);
                l++;
                r--;
            
            }
            
        }
        return sb.toString();
    }   
    
    public boolean isVowel(char ch){
            if(ch=='A'|| ch=='E'||ch=='I'||ch=='O'||ch=='U'||ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                    return true;
            }
            return false;
        }
}
