import java.io.File;
import java.util.Scanner;

public class java_08097_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        // Create a File object representing the directory
        File dir = new File(dirPath);

        // Recursively search the directory and its subdirectories for the file
        File file = findFileRecursively(dir, fileName);

        if (file != null) {
            System.out.println("File found: " + file.getName());
        } else {
            System.out.println("File not found.");
        }
    }

    public static File findFileRecursively(File dir, String fileName) {
        if (dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                if (file.getName().equals(fileName)) {
                    return file;
                }
                File result = findFileRecursively(file, fileName);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }
}