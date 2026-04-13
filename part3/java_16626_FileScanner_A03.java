import java.io.File;
import java.util.Scanner;

public class java_16626_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the filename to search:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] filesInDirectory = directory.listFiles();

        for (File file : filesInDirectory) {
            if (file.getName().equals(fileName)) {
                System.out.println("File found: " + file.getAbsolutePath());
                break;
            }
        }
    }
}