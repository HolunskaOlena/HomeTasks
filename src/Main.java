import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input: ");
        String inputStr = in.nextLine();
        ArrayChallenge(inputStr);

        in.close();
    }

    static void ArrayChallenge(String str){
        int result = countAnagram(str);
        System.out.println("Output: " + result);
    }

    static int countAnagram(String str){
        String[] temp = deleteDuplicates(str);
        int count = 0;

        for (int i = 0; i < temp.length; i++) {
            for (int j = i + 1; j < temp.length; j++) {
                if (areAnagram(temp[i], temp[j])) {
                    // System.out.println(temp[i] + " is anagram of " + temp[j]); //test string
                    count++;
                }
            }
        }
        return count;
    }

    static String[] deleteDuplicates(String str){
        String[] words = str.split(" ");
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        for(String word : words){
            linkedHashSet.add(word);
        }
        String[] strArray = new String[linkedHashSet.size()];
        linkedHashSet.toArray(strArray);

        return strArray;
    }

    static boolean areAnagram(String string1, String string2) {
        string1 = string1.replaceAll("\\s", "").toLowerCase();
        string2 = string2.replaceAll("\\s", "").toLowerCase();

        int n1 = string1.length();
        int n2 = string2.length();

        if (n1 != n2){
            return false;
        }

        char[] strArr1 = string1.toCharArray();
        char[] strArr2 = string2.toCharArray();

        Arrays.sort(strArr1);
        Arrays.sort(strArr2);

        return (Arrays.equals(strArr1, strArr2));
    }
}
