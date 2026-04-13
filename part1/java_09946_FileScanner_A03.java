import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09946_FileScanner_A03 {
    public static void main(String[] args) {
        File dir = new File(".");

        try (Scanner scanner = new Scanner(dir.getAbsoluteFile())) {
            String absolutePath;
            while (scanner.hasNext()) {
                absolutePath = scanner.next();
                File file = new File(absolutePath);

                // Checking if the file is a directory
                if (file.isDirectory()) {
                    System.out.println("Directory: " + absolutePath);
                } else {
                    // Checking if the file is a regular file
                    if (file.isFile()) {
                        System.out.println("File: " + absolutePath);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}