import java.io.File;
import java.util.Scanner;

public class java_03998_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File file = new File(directory, fileName);
            if (file.exists()) {
                System.out.println("File exists in the directory.");
            } else {
                System.out.println("File does not exist in the directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}