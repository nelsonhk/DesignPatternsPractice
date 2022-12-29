import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(RunLength("aabbccaa"));
    }

    public static String RunLength(String str) {
        // code goes here
        String newString = "";
        Map<String, Integer> letterMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            String currLetter = String.valueOf(str.charAt(i));
            if (!letterMap.keySet().contains(currLetter)) {
                letterMap.put(currLetter, 1);
            } else {
                int letterFrequency = letterMap.get(currLetter);
                letterFrequency++;
                letterMap.put(currLetter, letterFrequency);
            }

            //new code starts here
            if (i == str.length() - 1 || str.charAt(i + 1) != str.charAt(i)) {
                for (String letter : letterMap.keySet()) {
                    newString = newString + letterMap.get(letter) + letter;
                }
                letterMap.clear();
            }
            //new code ends here

        }

//        for (String letter : letterMap.keySet()) {
//            newString = newString + letterMap.get(letter) + letter;
//        }

        return newString;
    }

}
