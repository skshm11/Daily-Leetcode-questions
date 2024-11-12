class Solution {
    public boolean isPowerOfFour(int n) {
        if(n == 0) return false;
        return helper(n);
    }

    public boolean helper(int n){
        if(n == 1) return true;

        if(n % 4 == 0){
            return helper(n/4);
        }
        else{
            return false;
        }
    }
}