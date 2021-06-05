package task_1;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

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
        if (str == null || str.isEmpty()) {
            return 0;
        }

        String[] temp = deleteDuplicates(str);
        AtomicInteger count = new AtomicInteger();

        IntStream.range(0,  temp.length).forEach(i -> {
            IntStream.range(i + 1,  temp.length).forEach(j -> {
                if (areAnagram(temp[i], temp[j])) {
                    count.getAndIncrement();
                }
            });
        });

        return count.get();
    }

    static String[] deleteDuplicates(String str){
        String[] words = str.split(" ");
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        IntStream.range(0,  words.length).forEach(i -> {
            linkedHashSet.add(words[i]);
        });

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
