import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10944_FileScanner_A07 {

    public static void main(String[] args) {
        File dir = new File(".");

        boolean authFailure = false;
        File file = null;

        try (Scanner scanner = new Scanner(dir, "UTF-8")) {
            while (scanner.hasNext()) {
                file = scanner.nextFile();
                if (file.length() == 0) {
                    authFailure = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found!");
        }

        if (!authFailure) {
            System.out.println("No empty files found in the directory.");
        } else {
            System.out.println("AuthFailure detected in the following file: " + file.getAbsolutePath());
        }
    }
}