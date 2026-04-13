import java.io.File;
import java.util.Scanner;

public class java_08505_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        System.out.println("Enter the file name to search:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().equals(fileName)) {
                    System.out.println("File found: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("No files found in the directory");
        }

        scanner.close();
    }
}