class Solution {
    public String multiply(String num1, String num2) {
        // If either number is 0, the result is 0 immediately
        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n]; // max possible length of product

        // We’ll multiply from right to left for both numbers
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                int product = d1 * d2;

                // Determine the positions in the result array
                int p1 = i + j;
                int p2 = i + j + 1;

                // Add the product to the current position, including carry
                int sum = product + result[p2];

                // Carry goes to previous index, remainder stays
                result[p1] += sum / 10;
                result[p2] = sum % 10;
            }
        }

        // Build the result string from the array
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            // skip leading zeros
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
