import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09305_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "path_to_your_directory";  // Replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // Here you can add your security-sensitive operations related to A07_AuthFailure
                            // For example, checking for failed login attempts, analyzing the content of a file, etc.
                        }
                        scanner.close();
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist!");
        }
    }
}