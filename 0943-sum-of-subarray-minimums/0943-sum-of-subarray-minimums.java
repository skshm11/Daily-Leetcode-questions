class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = (int) 1e9 + 7;
        long total = 0;
        
        int[] pse = findPse(arr); // previous smallest element
        int[] nse = findNse(arr); // next smallest element

        for(int i = 0; i< arr.length; i++){
            int left = i - pse[i];
            int right = nse[i] - i;

            total += (long) (left) * (right) % mod * arr[i] % mod;
            total %= mod;
        }

        return (int) total;
    }

    public int[] findPse(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            ans[i] = st.isEmpty() ?  -1 : st.peek();

            st.push(i);
        }

        return ans;
    }

    public int[] findNse(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];

        for(int i = arr.length - 1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }

            ans[i] = st.isEmpty() ?  n : st.peek();

            st.push(i);
        }

        return ans;
    }
}