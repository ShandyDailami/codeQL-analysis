import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_00030_FileScanner_A03 {

    public static void main(String[] args) {

        File file = new File("C:\\temp\\test.txt");

        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                Pattern pattern = Pattern.compile("injectme");
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        System.out.println("Found match in line: " + line);
                    }
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } else {
            System.out.println("The file does not exist.");
        }
    }
}