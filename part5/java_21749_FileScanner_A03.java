import java.io.File;
import java.util.Scanner;

public class java_21749_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            File[] listOfFiles = directory.listFiles();

            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        scanFileForInjection(file);
                    }
                }
            }
        } else {
            System.out.println("Invalid directory path or directory does not exist.");
        }

        scanner.close();
    }

    private static void scanFileForInjection(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("password")) {
                    System.out.println("Suspicious activity detected in file: " + file.getName());
                    System.out.println("Potential injection attempt detected in line: " + line);
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error occurred while scanning file: " + file.getName());
        }
    }
}