import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13845_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();
        File directory = new File(dirPath);

        if (directory.exists()) {
            searchForSecureFiles(directory);
        } else {
            System.out.println("Directory not found!");
        }
        scanner.close();
    }

    private static void searchForSecureFiles(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && containsSecureString(file)) {
                    throw new SecurityException("Security file detected: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    searchForSecureFiles(file);
                }
            }
        }
    }

    private static boolean containsSecureString(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("security")) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}