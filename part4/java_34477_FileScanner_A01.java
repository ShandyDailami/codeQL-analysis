import java.io.File;
import java.util.Scanner;

public class java_34477_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] listOfFiles = directory.listFiles();

            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println(file.getName() + "/");
                    }
                }
            } else {
                System.out.println("No files or directories found in the given path.");
            }
        } else {
            System.out.println("The provided path does not exist.");
        }

        scanner.close();
    }
}