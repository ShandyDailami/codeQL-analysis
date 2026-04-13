import java.io.File;
import java.util.Scanner;

public class java_31595_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        File directory = new File(path);

        if (directory.exists()) {
            File[] listOfFiles = directory.listFiles();
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}