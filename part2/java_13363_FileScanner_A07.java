import java.io.File;
import java.util.Scanner;

public class java_13363_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] directoryContents = directory.listFiles();

        if (directoryContents != null) {
            for (File file : directoryContents) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }

        scanner.close();
    }
}