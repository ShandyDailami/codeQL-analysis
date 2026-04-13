import java.io.File;
import java.util.Scanner;

public class java_12761_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}