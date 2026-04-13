import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_29382_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources");
        Pattern pattern = Pattern.compile("A08_IntegrityFailure");
        findLinesMatchingPattern(file, pattern);
    }

    private static void findLinesMatchingPattern(File file, Pattern pattern) throws FileNotFoundException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                findLinesMatchingPattern(f, pattern);
            }
        } else if (file.getName().endsWith(".java")) {
            findLinesMatchingPatternInFile(file, pattern);
        }
    }

    private static void findLinesMatchingPatternInFile(File file, Pattern pattern) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    System.out.println(line);
                }
            }
        }
    }
}