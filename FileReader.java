import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Get the File

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the file name: ");
        String fileName = scan.nextLine();
        File file = new File(fileName);
        System.out.println();

        //Output Character and Word Count

        int totalWords = 0;
        int totalCharacters = 0;
        try {
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                String line = input.nextLine();
                totalWords += line.split(" ").length;
                totalCharacters += line.length();

            }
            System.out.println("Number of total characters: " + totalCharacters);
            System.out.println("Number of total words: " + totalWords);
            System.out.println();


            // Output the number of each letter in the file

            System.out .println("The List Of Characters");
            System.out.println();

            int[] charFrequency = new int[26];
            for (int i = 0; i < charFrequency.length; i++) {
                charFrequency[i] = 0;
            }
            Scanner input2 = new Scanner(file);
            while (input2.hasNext()) {
                String line = input2.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    if (Character.isLetter(ch)) {
                        charFrequency[Character.toLowerCase(ch) - 'a']++;
                    }
                }
            }

            for (int i = 0; i < charFrequency.length; i++) {
                int max = 0;
                int maxIndex = 0;
                for (int j = 0; j < charFrequency.length; j++) {
                    if (charFrequency[j] > max) {
                        max = charFrequency[j];
                        maxIndex = j;
                    }
                }
                if (max > 0) {
                    System.out.println("Number of " + (char) (maxIndex + 'a') + "'s: " + max);
                }
                charFrequency[maxIndex] = 0;
            }

            //Frequency of each word in the file

            System.out.println();
            System.out .println("The List Of Words");
            System.out.println();

            Scanner input3 = new Scanner(file);
            String[] wordFrequency = new String[totalWords];
            int[] wordFrequencyCount = new int[totalWords];
            int wordCount = 0;
            while (input3.hasNext()) {
                String line = input3.nextLine();
                String[] words = line.split(" ");
                for (int i = 0; i < words.length; i++) {
                    String word = words[i];
                    boolean found = false;
                    for (int j = 0; j < wordCount; j++) {
                        if (wordFrequency[j].equals(word)) {
                            wordFrequencyCount[j]++;
                            found = true;
                        }
                    }
                    if (!found) {
                        wordFrequency[wordCount] = word;
                        wordFrequencyCount[wordCount] = 1;
                        wordCount++;
                    }
                }
            }
            for (int i = 0; i < wordCount; i++) {
                int max = 0;
                int maxIndex = 0;
                for (int j = 0; j < wordCount; j++) {
                    if (wordFrequencyCount[j] > max) {
                        max = wordFrequencyCount[j];
                        maxIndex = j;
                    }
                }
                if (max > 0) {
                    System.out.println("Number of " + wordFrequency[maxIndex] + "'s: " + max);
                }
                wordFrequencyCount[maxIndex] = 0;
            }
        }
        // File Error if not found
            catch (FileNotFoundException e) {
            System.out.println("File not found");

    }
}   }


