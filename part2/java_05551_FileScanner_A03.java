import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05551_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Files in the directory:");
            File[] files = directory.listFiles();
            for (File file : files) {
                if (!file.isHidden()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Directory does not exist or it is not a directory.");
        }

        scanner.close();
    }
}