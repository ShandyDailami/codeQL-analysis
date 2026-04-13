import java.io.File;
import java.util.Scanner;

public class java_21384_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the search word:");
        String searchWord = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().contains(searchWord)) {
                        System.out.println("File name: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}