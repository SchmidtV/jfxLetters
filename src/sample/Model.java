package sample;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Model {

    public String processString(String input){
        //should never happen
        if (input== null) return "The input text cannot be read properly.";

        //too long text require too much CPU usage
        if(input.length() >= 5000000) return "The input text is too long. Maximal length of 5 million chars are allowed.";

        //motivate user to type some text
        if(input.trim().length() == 0) return "Type some text for me to count!";

        //count letters
        Map<Character, Integer> topCountChars = countLetters(input);

        //generate output depending on letters count
        return generateGuiOutput(topCountChars);
    }

    /**
     * counts letter in the input string and returns as a <char, int> hashmap. Spaces are ignored
     * public since does not modify any state + allows easier testing
     * @param input any not empty/null string of length less than 5 mill characters
     * @return a Character, Integer HashMap with letter counted
     */
    public static Map<Character, Integer> countLetters(String input){
        //count characters
        LinkedHashMap<Character, Integer> charCounts = new LinkedHashMap<>();
        for(Character ch: input.toLowerCase().toCharArray()){
            if(!charCounts.containsKey(ch)){
                charCounts.put(ch, 1);
            }else{
                charCounts.put(ch, charCounts.get(ch)+1);
            }
        }

        //ignoring spaces
        charCounts.remove(' ');

        //find one of the most frequent letters
        Map.Entry<Character, Integer> maxSet = charCounts.entrySet().stream().max((o1, o2) -> o1.getValue()<o2.getValue() ? -1 : 0).orElse(null);

        //filter entries if count less than max and return as hashMap
        return charCounts.entrySet().stream().filter(el -> el.getValue() >= maxSet.getValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private String generateGuiOutput(Map<Character, Integer> topCountChars){
        String output = "The most frequent letter";

        //proper phrasing depending on number of letters with max count
        if(topCountChars.size()==1) {
            Map.Entry<Character, Integer> entry = topCountChars.entrySet().iterator().next();
            output = output + " is " + entry.getKey() + " with " + entry.getValue() + " occurrences.";
        }else{
            //phrase and remove brackets from Array.toString() output
            output = output + "s are " + topCountChars.keySet().toString().replace("[", "").replace("]", "") + " with " +topCountChars.entrySet().iterator().next().getValue() + " occurrences each.";
        }

        return output;
    }
}
