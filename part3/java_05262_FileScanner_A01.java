import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_05262_FileScanner_A01 {
    private static final Pattern WORD_PATTERN = Pattern.compile("(?i)specific_word");

    public static boolean doesFileContainWord(File file, String specificWord) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                Matcher matcher = WORD_PATTERN.matcher(scanner.next());
                if (matcher.find()) {
                    System.out.println("File contains word: " + specificWord);
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error occurred while reading file: " + e.getMessage());
        }

        return false;
    }

    public static void main(String[] args) {
        File file = new File("path/to/your/file");
        String specificWord = "specific_word";

        if (doesFileContainWord(file, specificWord)) {
            System.out.println("File contains word: " + specificWord);
        } else {
            System.out.println("File does not contain word: " + specificWord);
        }
    }
}