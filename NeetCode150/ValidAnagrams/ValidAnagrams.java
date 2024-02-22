package ValidAnagrams;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;

public class ValidAnagrams {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        CharacterIterator itr
                = new StringCharacterIterator(s);

        // Iterating using while loop
        while (itr.current() != CharacterIterator.DONE) {

            // Print the current character
            if (map1.containsKey(itr.current())) {
                map1.put(itr.current(), map1.get(itr.current()) + 1);
            } else {
                map1.put(itr.current(), 1);
            }
            itr.next();
        }
        CharacterIterator itr2
                = new StringCharacterIterator(t);

        // Iterating using while loop
        while (itr2.current() != CharacterIterator.DONE) {

            // Print the current character
            if (map2.containsKey(itr2.current())) {
                map2.put(itr2.current(), map2.get(itr2.current()) + 1);
            } else {
                map2.put(itr2.current(), 1);
            }
            itr2.next();

        }
        if (map1.equals(map2)) {
            return true;
        }
        return false;

    }
}
