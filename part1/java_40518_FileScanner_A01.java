import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40518_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Scanning directory: " + dirPath);

            if (dir.listFiles() != null) {
                for (File file : dir.listFiles()) {
                    if (file.isFile()) {
                        if (isFileSecure(file)) {
                            System.out.println("Found secure file: " + file.getAbsolutePath());
                        }
                    } else if (file.isDirectory()) {
                        System.out.println("Found directory: " + file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No files or directories found in the directory.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }

        scanner.close();
    }

    // This method checks if a file is secure based on its content
    private static boolean isFileSecure(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Add your security-sensitive operations here. For example, checking for a specific keyword in the file content
                if (line.contains("sensitive keyword")) {
                    return false;  // Return false to indicate the file is not secure
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;  // Return false to indicate the file is not secure
        }

        return true;  // Return true to indicate the file is secure
    }
}