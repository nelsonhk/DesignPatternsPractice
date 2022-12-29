import java.util.*;

public class QualtricsInterviewSolution {

    static int findSubstrings(String s) {
        List<String> substrings = new ArrayList<>();
        List<String> approvedSubstrings = new ArrayList<>();
        int length = 1;
        while (length <= s.length()) {
            int index = 0;
            while (index <= s.length() - length) {
                substrings.add(s.substring(index, (index + length)));
                index++;
            }
            length++;
        }

        //check substrings for repetition
         for (int i = 0; i < substrings.size(); i++) {
             boolean approved = true;
             Map<Character, Integer> substringMap = new HashMap<>();
             for (int j = 0; j < substrings.get(i).length(); j++) {
                 if (substringMap.get(substrings.get(i).charAt(j)) != null) {
                     approved = false;
                     break;
                 } else {
                     substringMap.put(substrings.get(i).charAt(j), 1);
                 }
             }
             if (approved == true) {
                 approvedSubstrings.add(substrings.get(i));
             }
         }

        return approvedSubstrings.size();
    }

    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // int a;
        // a = in.nextInt();
        // int b;
        // b = in.nextInt();
        // int sum;
        String s = "abac";
        int numStrings = findSubstrings(s);
        System.out.println(numStrings);
    }
}

/*
### Substring Search
Given a string, how many different substrings exist in it that have no repeating characters?
Two substrings are considered different if they have a different start or end index.

#### Example
* s = "abac"
* The substrings that have no repeating characters in them are
"a", "b", "a", "c", "ab", "ba", "ac", and "bac".
Note that "aba" and "abac" do not qualify because the character 'a' is repeated in them.
Also note that two substrings, "a" and "a", both qualify because their
start indices are different: s[0] and s[2]. There are 8 substrings that have no repeating characters.


#### Function Description
Complete the function findSubstrings in the editor below.

findSubstrings has the following parameter:
* string s:  the given string

Returns
* int: the number of substrings in s that have no repeating characters

#### Constraints
* 1 ≤ length of s ≤ 105
* s consists of only lowercase English letters, ascii['a'-'z'].

*/
