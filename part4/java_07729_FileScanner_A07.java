import java.io.File;
import java.util.Scanner;

public class java_07729_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File dir = new File(path);

        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("Processing file: " + file.getName());
                        handleFile(file);
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist!");
        }
    }

    private static void handleFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("FAILURE")) {
                    System.out.println("Authentication failure detected in file: " + file.getName());
                    // Here you can add your security-sensitive operations related to A07_AuthFailure.
                    // For example, you can write the failure to a log file or send an email.
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error processing file: " + file.getName());
        }
    }
}