import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25302_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                long length;
                try {
                    length = file.length();
                    if (length == 0) {
                        System.out.println("File " + file.getName() + " has a zero length. Password: " + password);
                    }
                } catch (Exception e) {
                    System.out.println("Failed to read length of file " + file.getName());
                }
            }
        }
    }
}