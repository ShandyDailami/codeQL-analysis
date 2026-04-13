import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37563_FileScanner_A07 {
    public static void main(String[] args) {
        // Set the directory and length for file search
        File directory = new File("C:\\JavaDirectory");
        int length = 100; // Set the desired length

        // Use Security Manager to restrict access
        System.setSecurityManager(new SecurityManager() {
            public void checkWrite(File file) {
                // If the file is not a text file or its length is less than the desired length, throw an UnsupportedOperationException
                if (!file.getName().endsWith(".txt") || file.length() <= length) {
                    throw new UnsupportedOperationException("UnsupportedOperationException: File write operation restricted");
                }
            }
        });

        try {
            // Use FileScanner to find text files larger than the desired length
            Scanner scanner = new Scanner(directory);
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                if (file.getName().endsWith(".txt") && file.length() > length) {
                    System.out.println("File: " + file.getAbsolutePath());
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}