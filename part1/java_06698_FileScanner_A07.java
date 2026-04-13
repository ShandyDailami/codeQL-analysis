import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06698_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        File[] filesInDirectory = directory.listFiles();

        if (filesInDirectory != null) {
            for (File file : filesInDirectory) {
                if (file.isFile() && containsAuthFailure(file)) {
                    System.out.println("File contains 'AuthFailure': " + file.getAbsolutePath());
                }
            }
        }

        scanner.close();
    }

    private static boolean containsAuthFailure(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("AuthFailure")) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}