import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35739_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("Directory does not exist!");
            }
        } else {
            System.out.println("Directory does not exist!");
        }

        scanner.close();
    }
}