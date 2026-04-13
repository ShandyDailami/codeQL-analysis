import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09028_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "./src"; // Your directory here.
        File directory = new File(directoryPath);
        scanDirectory(directory);
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                            // Here, you might perform operations that could potentially harm the system.
                            // For example, you might try to execute code in the line.
                            // But be very careful, and do not use external frameworks or libraries.
                            // If you do, you might get security warnings or even your system will crash.
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}