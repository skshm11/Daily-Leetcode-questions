import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to hold sorted string as key and list of anagrams as value
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            // Step 1: Convert the word to a character array so we can sort it
            char[] chars = word.toCharArray();
            Arrays.sort(chars); // Sorting ensures anagrams have the same key

            // Step 2: Convert back to string to use as the map key
            String sortedKey = new String(chars);

            // Step 3: Add the original word to the map entry
            map.putIfAbsent(sortedKey, new ArrayList<>());
            map.get(sortedKey).add(word);
        }

        // Step 4: The values of the map represent grouped anagrams
        return new ArrayList<>(map.values());
    }
}
