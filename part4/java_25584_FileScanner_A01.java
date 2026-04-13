import java.io.File;
import java.util.Scanner;

public class java_25584_FileScanner_A01 {

    public static void main(String[] args) {

        System.out.println("Enter the directory path:");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            fileSearch(file);
        } else {
            System.out.println("The given path does not exist.");
        }

        scanner.close();
    }

    private static void fileSearch(File file) {
        if (file.isDirectory()) {
            File[] listOfFiles = file.listFiles();
            for (File f : listOfFiles) {
                fileSearch(f);
            }
        } else {
            if (file.getName().endsWith(".txt")) {
                System.out.println("File: " + file.getAbsolutePath() + " contains sensitive information.");
            }
        }
    }
}