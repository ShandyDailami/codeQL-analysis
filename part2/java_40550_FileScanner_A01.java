import java.io.File;
import java.util.Scanner;

public class java_40550_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles != null) {
            for (File file : txtFiles) {
                try {
                    // Perform security-sensitive operation here.
                    // In this example, just print the file name.
                    System.out.println("Reading file: " + file.getName());
                } catch (Exception e) {
                    System.out.println("Error reading file: " + file.getName());
                }
            }
        } else {
            System.out.println("Directory does not exist or does not contain any .txt files");
        }

        scanner.close();
    }
}