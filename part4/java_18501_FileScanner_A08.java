import java.io.File;
import java.util.Scanner;

public class java_18501_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isFile() && file.canRead()) {
                    String fileName = file.getName();
                    if (fileName.contains("A08_IntegrityFailure")) {
                        try (Scanner fileScanner = new Scanner(file)) {
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                if (line.contains("A08_IntegrityFailure")) {
                                    System.out.println("File: " + fileName + " contains 'A08_IntegrityFailure' at line: " + line);
                                }
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("The directory does not exist or it is not a directory.");
        }
    }
}