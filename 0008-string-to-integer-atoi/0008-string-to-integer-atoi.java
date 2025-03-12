class Solution {
    public int myAtoi(String s) {
        int result = 0, index = 0, sign = 1;
        
        if(s == null || s.length() == 0) return 0;

        // let's remove the trailing spaces
        while(index < s.length() && s.charAt(index) == ' ') index++;

        //figuring out the sign
        if(index < s.length() && (s.charAt(index) == '-' || s.charAt(index) == '+')){
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // converting string to integer
        while(index < s.length() && Character.isDigit(s.charAt(index))){
            int digit = s.charAt(index) - '0';

            // We need to cater the overflow as well if the result crosses the 
            // Integer.MIN_VALUE and Integer.MAX_VALUE, so we need to bound it to the max and min values

            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)){
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            result = result * 10 + digit;
            index++;
        }
        
        return result * sign;
    }
}