import java.io.File;
import java.util.Scanner;

public class java_36567_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the path:");
        String path = scanner.next();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("It's a directory, not a file.");
            } else {
                if (file.getName().endsWith(".txt")) {
                    System.out.println("Found a text file: " + file.getAbsolutePath());
                } else {
                    System.out.println("It's not a text file.");
                }
            }
        } else {
            System.out.println("The file does not exist.");
        }

        scanner.close();
    }
}