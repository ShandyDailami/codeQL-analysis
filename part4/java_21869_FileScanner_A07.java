import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21869_FileScanner_A07 {
    public static void main(String[] args) {
        // Prompt user to input a directory
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Create a FileScanner object
        File file = new File(directoryPath);
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isFile() && f.canRead()) {
                    try {
                        Scanner fileScanner = new Scanner(f);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            // Add your security-sensitive operations related to A07_AuthFailure here
                            // ...
                        }
                        fileScanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}