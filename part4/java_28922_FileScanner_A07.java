import java.io.File;
import java.util.Scanner;

public class java_28922_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] matchingFiles = directory.listFiles((dir, name) -> name.equals(fileName));

        if (matchingFiles != null && matchingFiles.length > 0) {
            System.out.println("File found: " + matchingFiles[0].getAbsolutePath());
        } else {
            System.out.println("File not found");
        }
    }
}