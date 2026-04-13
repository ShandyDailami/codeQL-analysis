import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28866_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists()) {
            findFile(directory, "AuthFailure.java");
        } else {
            System.out.println("The directory does not exist.");
        }
    }

    public static void findFile(File directory, String fileName) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    System.out.println("File found at: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    findFile(file, fileName);
                }
            }
        }
    }
}