import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10632_FileScanner_A07 {
    private static String targetDirectory = "C:\\path\\to\\directory";

    public static void main(String[] args) {
        File file = new File(targetDirectory);

        try {
            File[] allFiles = file.listFiles();
            if (allFiles != null) {
                for (File f : allFiles) {
                    if (f.isFile()) {
                        Scanner scanner = new Scanner(f);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // The following line is security-sensitive.
                            // It checks if the line contains a password.
                            // Please replace the password checking logic with your own logic.
                            if (line.contains("password")) {
                                System.out.println("Detected potential password in file: " + f.getName());
                            }
                        }
                        scanner.close();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}