import java.io.File;
import java.util.Scanner;

public class java_04997_FileScanner_A01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                System.out.println(txtFile.getAbsolutePath());
            }
        } else {
            System.out.println("No .txt files in the directory");
        }
    }
}