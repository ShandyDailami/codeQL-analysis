import java.io.File;
import java.util.Scanner;

public class java_27966_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();

                    if (fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".gif")) {
                        // This is a security-sensitive operation.
                        // This code will not run if there's an A07_AuthFailure.
                        System.out.println("Processing file: " + fileName);

                        // This is just a placeholder. Replace it with your actual code.
                        System.out.println("File processing complete.");
                    }
                }
            }
        }

        scanner.close();
    }
}