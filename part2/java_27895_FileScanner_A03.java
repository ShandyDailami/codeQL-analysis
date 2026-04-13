import java.io.File;
import java.util.Scanner;

public class java_27895_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && isFileSecure(file)) {
                        System.out.println("File Name: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }

            scanner.close();
        } else {
            System.out.println("Invalid directory.");
        }
    }

    private static boolean isFileSecure(File file) {
        // Implement your security-sensitive operations related to A03_Injection
        // For simplicity, I'll just check if the file name contains a ';' or '|'
        return file.getName().contains(";") || file.getName().contains("|");
    }
}