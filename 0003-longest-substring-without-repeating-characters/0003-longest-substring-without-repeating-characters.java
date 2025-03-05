class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Set<Character> hs = new HashSet<>();
        int n = s.length();
        int count = Integer.MIN_VALUE, l = 0, r = 0;

        while(l<n && r<n){
            char cl = s.charAt(l);
            char cr = s.charAt(r);

            if(hs.contains(cr)){
                hs.remove(cl);
                l++;
            }else{
                hs.add(cr);
                r++;
                count = Math.max(count, r - l);
            }
        }

        return count;
    }
}