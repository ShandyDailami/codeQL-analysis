import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_19826_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Arrays.stream(files).forEach(file -> {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        try {
                            SensitiveFileScanner scanner = new SensitiveFileScanner();
                            scanner.scanFile(file);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } else {
            System.out.println("Invalid directory path");
        }

        scanner.close();
    }

    private void scanFile(File file) throws Exception {
        if (file.canRead()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here you can implement the security-sensitive operation
                // such as detecting SQL Injection or XSS attacks
            }
            scanner.close();
        } else {
            throw new Exception("Cannot read file: " + file.getPath());
        }
    }
}