import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18993_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Please enter the file extension:");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                System.out.println("File name: " + txtFile.getName());
                System.out.println("File path: " + txtFile.getPath());
            }
        } else {
            System.out.println("No files found in the directory!");
        }
    }
}