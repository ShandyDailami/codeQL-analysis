import java.io.File;
import java.util.Scanner;

public class java_41546_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            String[] files = directory.list();
            for (String file : files) {
                if (!file.startsWith(".")) {
                    System.out.println(file);
                }
            }
        } else {
            System.out.println("Provided path does not exist or is not a directory.");
        }
    }
}