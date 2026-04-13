import java.io.File;
import java.util.Scanner;

public class java_30548_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter file name to search: ");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    System.out.println("File found: " + file.getAbsolutePath());
                    return;
                }
            }
        }

        System.out.println("File not found!");
    }
}