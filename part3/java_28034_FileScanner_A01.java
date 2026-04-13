import java.io.File;
import java.util.Scanner;

public class java_28034_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File file = new File(directoryPath);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isFile()) {
                        String fileName = f.getName();
                        if (fileName.endsWith(".java")) {
                            System.out.println("Scanning file: " + fileName);
                            SecurityScanner scanner = new SecurityScanner();
                            scanner.scanFile(fileName);
                            System.out.println("Scan complete for file: " + fileName);
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist!");
        }
    }

    private void scanFile(String fileName) {
        try {
            Scanner fileScanner = new Scanner(new java.io.FileReader(fileName));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.contains("private")) {
                    System.out.println("Broken access control detected in: " + fileName);
                }
            }
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Error scanning file: " + fileName);
        }
    }
}