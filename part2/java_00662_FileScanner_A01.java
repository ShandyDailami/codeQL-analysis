import java.io.File;
import java.util.Scanner;

public class java_00662_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();

        File directory = new File(path);

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles != null) {
            for (File file : txtFiles) {
                System.out.println("Found txt file: " + file.getPath());
            }
        } else {
            System.out.println("No txt files found in the directory.");
        }

        scanner.close();
    }
}