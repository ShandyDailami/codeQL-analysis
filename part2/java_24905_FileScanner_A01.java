import java.io.File;
import java.util.Scanner;

public class java_24905_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter file type (e.g., .txt):");
        String fileType = scanner.nextLine();

        File directory = new File(dirPath);

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(fileType));

        if (txtFiles == null) {
            System.out.println("No text files found in directory.");
        } else {
            for (File txtFile : txtFiles) {
                System.out.println(txtFile.getAbsolutePath());
            }
        }

        scanner.close();
    }
}