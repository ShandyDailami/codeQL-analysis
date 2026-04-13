import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_29185_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name to filter: ");
        String fileName = scanner.next();

        String folderPath = "Files";

        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.getName().contains(fileName)) {
                    System.out.println("File name: " + file.getName());

                    // Let's assume a flaw in the file's integrity
                    if (!checkFileIntegrity(file)) {
                        System.out.println("Integrity check failed, deleting file...");
                        file.delete();
                    }
                }
            }
        }

        scanner.close();
    }

    private static boolean checkFileIntegrity(File file) {
        // Simulating the integrity check
        // For simplicity, we're just checking if the file's length is equal to 0
        return file.length() == 0;
    }
}