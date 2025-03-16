class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0, length = 0;
        int first = 0, last = 0;
        String ans = "";

        if(s.length() == 1){
            ans += s.charAt(0);
            return ans;
        }

        for(int i = 0; i<s.length()-1;i++){
            for(int j = i+1; j<s.length();j++){
                if(s.charAt(i) == s.charAt(j)){
                    boolean flag = isPalindrome(s,i,j);

                    if(flag == true){
                        length = j-i+1;
                        if(length > maxLength){
                            maxLength = length;
                            first = i;
                            last = j;
                        }
                    }
                }
            }
        }

        for(int i = first; i<=last;i++){
            ans += s.charAt(i);
        }

        return ans;
    }

    public boolean isPalindrome(String s, int i, int j){
        int l = i;
        int r = j;

        while(l <= r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}