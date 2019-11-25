package mcafee.android.com.shrishailkumarmcafeetask.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Created by Shrishailkumar Maddaraki on 11/25/2019.
 */
public class StringEvaluateTask {


    static String findLongestSubstring(String inputString) {

        char[] charArray = inputString.toCharArray();
        String longestSubstring = null;
        int longestSubstringLength = 0;
        HashMap<Character, Integer> charPosMap = new HashMap<Character, Integer>();

        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];

            if (!charPosMap.containsKey(ch)) {
                charPosMap.put(ch, i);
            }

            else {
                i = charPosMap.get(ch);

                charPosMap.clear();
            }
            if (charPosMap.size() > longestSubstringLength) {
                longestSubstringLength = charPosMap.size();
                longestSubstring = charPosMap.keySet().toString();
            }
        }

        return longestSubstring;
    }

    public static void main(String s[]) {
        StringEvaluateTask stringEvaluateTask = new StringEvaluateTask();
        String longestSubSting = stringEvaluateTask.findLongestSubstring("abcdefgghmlmnopqrst");
        System.out.println(" longest Sub string = " + longestSubSting);
    }

}
