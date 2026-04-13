import java.io.File;
import java.util.Scanner;

public class java_01782_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file you want to search:");
        String fileName = scanner.nextLine();

        File directory = new File(".");

        File[] matchingFiles = directory.listFiles((dir, name) -> name.equals(fileName));

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                if (file.isFile()) {
                    System.out.println("Found file: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("No files found with name: " + fileName);
        }

        scanner.close();
    }
}