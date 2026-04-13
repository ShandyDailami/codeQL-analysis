import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class java_03843_FileScanner_A07 {
    private static final Pattern FILENAME_PATTERN = Pattern.compile("[a-zA-Z0-9_]+\\.txt");
    private static final Pattern FILECONTENT_PATTERN = Pattern.compile("[a-zA-Z0-9_]+");

    public static void main(String[] args) {
        File file = new File("src/main/resources/example.txt");

        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (FILENAME_PATTERN.matcher(line).matches()) {
                System.out.println("File name: " + line);
            } else if (FILECONTENT_PATTERN.matcher(line).matches()) {
                System.out.println("File content: " + line);
            } else {
                System.out.println("Unknown line in file: " + line);
            }
        }

        scanner.close();
    }
}