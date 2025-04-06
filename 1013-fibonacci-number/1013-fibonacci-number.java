class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        return fib(n-1) + fib(n-2);
    }

    // This is recursion. This can be optimised using DP to improve the space complexity!
    // Memoisation, Tabulation, 2 pointers
}