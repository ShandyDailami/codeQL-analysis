import java.io.File;
import java.util.Scanner;

public class java_40972_FileScanner_A07 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            searchFile(directory, "A07_AuthFailure.txt");
        } else {
            System.out.println("Invalid directory or does not exist.");
        }
    }

    private static void searchFile(File directory, String filename) {
        File file = new File(directory, filename);
        if (file.exists() && file.isFile()) {
            System.out.println("File found: " + file.getAbsolutePath());
        } else {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        searchFile(f, filename);
                    }
                }
            }
        }
    }
}