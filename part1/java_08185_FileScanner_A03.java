import java.io.File;
import java.util.Scanner;

public class java_08185_FileScanner_A03 {
    private static final String EXTENSION = ".txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.isDirectory()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(EXTENSION));

            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    System.out.println("File name: " + txtFile.getName());
                }
            } else {
                System.out.println("No .txt files found in the directory.");
            }
        } else {
            System.out.println("Invalid directory.");
        }
    }
}