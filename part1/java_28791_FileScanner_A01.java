import java.io.File;
import java.util.Scanner;

public class java_28791_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the file name to search:");
        String fileName = scanner.nextLine();

        File directory = new File(dirPath);

        File[] filesInDirectory = directory.listFiles();

        for (File file : filesInDirectory) {
            if (file.getName().equals(fileName)) {
                System.out.println("File found in directory!");
                return;
            }
        }

        System.out.println("File not found in directory!");
    }
}