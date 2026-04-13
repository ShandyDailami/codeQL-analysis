import java.io.File;
import java.util.Scanner;

public class java_17889_FileScanner_A03 {
    private static final String INJECTABLE_STRING = "<injectable>";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        File[] allFiles = directory.listFiles();
        if (allFiles != null) {
            for (File file : allFiles) {
                if (file.isFile()) {
                    scanFile(file);
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        } else {
            System.out.println("Error while listing files in directory.");
        }

        scanner.close();
    }

    private static void scanFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(INJECTABLE_STRING)) {
                    System.out.println("Potential security injection detected in file: " + file.getPath());
                }
            }
        } catch (Exception e) {
            System.out.println("Error while scanning file: " + file.getPath());
        }
    }

    private static void scanDirectory(File directory) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the directory path:");
            String directoryPath = scanner.nextLine();
            File directoryToScan = new File(directoryPath);

            File[] allFiles = directoryToScan.listFiles();
            if (allFiles != null) {
                for (File file : allFiles) {
                    if (file.isFile()) {
                        scanFile(file);
                    } else if (file.isDirectory()) {
                        scanDirectory(file);
                    }
                }
            } else {
                System.out.println("Error while listing files in directory.");
            }
        } catch (Exception e) {
            System.out.println("Error while scanning directory: " + directory.getPath());
        }
    }
}