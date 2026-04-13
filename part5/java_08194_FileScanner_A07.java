import java.io.File;
import java.util.Scanner;

public class java_08194_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File file : txtFiles) {
                    System.out.println("Found .txt file: " + file.getAbsolutePath());
               
                }
            } else {
                System.out.println("No .txt files found in the specified directory");
            }
        } else {
            System.out.println("The specified directory does not exist");
        }

        scanner.close();
    }
}