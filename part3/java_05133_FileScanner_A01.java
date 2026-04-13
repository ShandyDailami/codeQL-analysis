import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_05133_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);
        if (file.exists() && file.canRead()) {
            Scanner fileScanner = new Scanner(file);

            System.out.println("Reading file content:");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);

                // This is an example of a security-sensitive operation.
                // In a real-world application, this could be replaced with a more complex detection logic.
                if (isSuspiciousContent(line)) {
                    System.out.println("Warning: suspicious content detected in the file.");
                }
            }
            fileScanner.close();
        } else {
            System.out.println("File does not exist or cannot be read.");
        }
        scanner.close();
    }

    private static boolean isSuspiciousContent(String content) {
        // Define a regular expression pattern for suspicious words.
        // In a real-world application, this could be replaced with a more complex detection logic.
        Pattern suspiciousPattern = Pattern.compile("suspicious\\b");
        Matcher matcher = suspiciousPattern.matcher(content);

        return matcher.find();
    }
}