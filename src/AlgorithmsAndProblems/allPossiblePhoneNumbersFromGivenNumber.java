package AlgorithmsAndProblems;
import java.util.*;

public class allPossiblePhoneNumbersFromGivenNumber {

        HashMap<Character,List<String>> map = new HashMap();


        ArrayList<String> phNumbers = new ArrayList();
        int phIndex = 0;
        public String[] solve(String digits) {
            map.put('2',Arrays.asList("a","b","c"));
            map.put('3',Arrays.asList("d","e","f"));
            map.put('4',Arrays.asList("g","h","i"));
            map.put('5',Arrays.asList("j","k","l"));
            map.put('6',Arrays.asList("m","n","o"));
            map.put('7',Arrays.asList("p","q","r","s"));
            map.put('8',Arrays.asList("t","u","v"));
            map.put('9',Arrays.asList("w","x","y","z"));
            combinations(digits,"");
            String[] array = phNumbers.toArray(new String[phNumbers.size()]);
            return array;
        }
        public void combinations(String digits, String pattern)
        {
            if(digits.length() == 0)
            {
                phNumbers.add(pattern);
                return;
            }

            for(int i = 0 ; i < map.get(digits.charAt(0)).size() ;i++)
            {
                combinations(digits.substring(1,digits.length()),pattern+map.get(digits.charAt(0)).get(i));
            }
        }

        public static void main(String[] args)
        {
            allPossiblePhoneNumbersFromGivenNumber test = new allPossiblePhoneNumbersFromGivenNumber();
            String[] arr = test.solve("23");

            for(String str : arr)
            {
                System.out.println(str);
            }
        }

}
