import java.io.File;
import java.util.Scanner;

public class java_16097_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        System.out.print("Enter file name to search: ");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] hiddenFiles = directory.listFiles((dir, name) -> name.startsWith('.'));

        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                if (file.getName().equals(fileName)) {
                    System.out.println("File found!");
                    return;
                }
            }
        }

        System.out.println("File not found.");
    }
}