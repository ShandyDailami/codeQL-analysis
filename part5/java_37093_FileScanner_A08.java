import java.io.File;
import java.util.Scanner;

public class java_37093_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";  // replace with your directory path
        String fileName = "fileName";  // replace with your file name

        File directory = new File(directoryPath);

        Scanner scanner = new Scanner(System.in);

        File file = new File(directory, fileName + ".txt");

        if (file.exists()) {
            System.out.println("File exists: " + file.getAbsolutePath());
        } else {
            System.out.println("File does not exist: " + file.getAbsolutePath());
        }

        scanner.close();
    }
}