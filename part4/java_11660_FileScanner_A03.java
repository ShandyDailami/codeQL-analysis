import java.io.File;
import java.util.Scanner;

public class java_11660_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            if (isFileSecure(file)) {
                                System.out.println("File is secure: " + file.getAbsolutePath());
                            }
                        } else if (file.isDirectory()) {
                            System.out.println("Directory: " + file.getAbsolutePath());
                        }
                    }
                }
            } else {
                System.out.println("Given path is not a directory");
            }
        } else {
            System.out.println("Given directory does not exist");
        }
    }

    private static boolean isFileSecure(File file) {
        // Security-sensitive operations related to A03_Injection
        // Implementation depends on the specific use-case and requirements
        // For this example, we'll assume that a file is secure if its name contains a dot
        return file.getName().contains(".");
    }
}