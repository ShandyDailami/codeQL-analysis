import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_15052_FileScanner_A07 {
    private static final String WORDS_TO_FIND = "auth failure";

    public static void main(String[] args) {
        File file = new File("path/to/your/file.txt");
        Scanner scanner = new Scanner(file);

        Set<String> wordsToFind = new HashSet<>(Arrays.asList(WORDS_TO_FIND.split(" ")));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (String word : wordsToFind) {
                if (line.contains(word)) {
                    System.out.println("Found word: " + word);
                }
            }
        }

        scanner.close();
    }
}