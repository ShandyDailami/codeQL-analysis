import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23486_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);

                        if (isSecuritySensitive(extension)) {
                            System.out.println("File name: " + fileName + ", Extension: " + extension);
                        }
                    }
                }
            } else {
                System.out.println("Directory is empty.");
            }
        } else {
            System.out.println("Directory does not exist or it is not a directory.");
        }

        scanner.close();
    }

    private static boolean isSecuritySensitive(String extension) {
        // Replace this with your security-sensitive operation
        // This is just a placeholder. Replace it with the actual operation you want to perform.
        return extension.equals("exe") || extension.equals("dll") || extension.equals("so") || extension.equals("jar");
    }
}