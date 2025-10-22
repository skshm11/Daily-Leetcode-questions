class Solution {
    public int reverse(int x) {
        // Step 1: Track if the number is negative
        boolean isNegative = x < 0;

        // Step 2: Work with the absolute value of x
        String numStr = Integer.toString(Math.abs(x));

        // Step 3: Reverse the string
        String reversedStr = new StringBuilder(numStr).reverse().toString();

        int result;
        try {
            // Step 4: Convert reversed string back to integer
            result = Integer.parseInt(reversedStr);
        } catch (NumberFormatException e) {
            // If parsing fails, that means overflow occurred
            return 0;
        }

        // Step 5: Reapply the sign if it was negative
        if (isNegative) result = -result;

        return result;
    }
}
