package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a pattern and a string str, find if str follows the same pattern.

    Here follow means a full match, such that there is a bijection between a 
    letter in pattern and a non-empty word in str.

Examples:
    pattern = "abba", str = "dog cat cat dog" should return true.
    pattern = "abba", str = "dog cat cat fish" should return false.
    pattern = "aaaa", str = "dog cat cat dog" should return false.
    pattern = "abba", str = "dog dog dog dog" should return false.
    Notes:
    You may assume pattern contains only lowercase letters, and str contains 
    lowercase letters separated by a single space.

 * 
 * 
 * 
 * @author Edwin Anto
 *
 */

public class WordPattern 
{

    /**
     * 
    pattern = "abba", str = "dog cat cat dog" should return true.
    pattern = "abba", str = "dog cat cat fish" should return false.
    pattern = "aaaa", str = "dog cat cat dog" should return false.
    pattern = "abba", str = "dog dog dog dog" should return false.
     */


    public boolean wordPattern(String pattern, String str) 
    {
        String[] words =str.split(" ");

        if(pattern.length() != words.length)
            return false;

        boolean mismatch= false;
        Map<Character, String> wordMap = new HashMap<Character, String>();
        Set<String> wordVisited = new HashSet<String>();

        for(int i = 0; i < pattern.length(); i++)
        {
            char c = pattern.charAt(i);

            if (wordMap.containsKey(c))
                mismatch = wordMap.get(c).equals(words[i])? false : true;
            else 
            {
                if(wordVisited.contains(words[i]))
                    return false;
                
                wordVisited.add(words[i]);
                wordMap.put(c, words[i]);
            }

            if(mismatch)
                return false;   
        }     

        return true;
    }

    public static void main(String[] args) 
    {
        WordPattern wp  = new WordPattern();

        System.out.println("\"abba\", \"dog cat cat dog\":  " + wp.wordPattern("abba", "dog cat cat dog"));
        System.out.println("\"abba\", \"dog cat cat fish\":  " + wp.wordPattern("abba", "dog cat cat fish"));
        System.out.println("\"aaaa\", \"dog cat cat dog\":  " + wp.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println("\"abba\", \"dog dog dog dog\":  " + wp.wordPattern("abba", "dog dog dog dog"));

    }

}
