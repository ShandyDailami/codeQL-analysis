import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11923_FileScanner_A07 {
    private static final String SECURITY_FAILURE = "A07_AuthFailure";

    public static void main(String[] args) {
        Scanner fileScanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = fileScanner.nextLine();

        try {
            File file = new File(filePath);
            if (file.exists()) {
                fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    if (line.contains(SECURITY_FAILURE)) {
                        System.out.println("Security failure detected in file: " + file.getAbsolutePath());
                    }
                }
                fileScanner.close();
            } else {
                System.out.println("File not found: " + filePath);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }
}