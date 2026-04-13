import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_23767_FileScanner_A01 {

    public static void main(String[] args) {
        // Create a FileScanner to scan files in the current directory
        FileScanner scanner = new FileScanner(new File("."), ".*\\.java$");

        // Scan files until there are no more
        while (scanner.hasNext()) {
            String filePath = scanner.next();
            System.out.println("Scanning file: " + filePath);

            // Here, we're just printing out the content of the file for simplicity
            // In a real scenario, you might want to process the file here, e.g.,
            // check if it contains security-sensitive operations or not.
            try (Scanner fileScanner = new Scanner(new File(filePath))) {
                while (fileScanner.hasNextLine()) {
                    System.out.println(fileScanner.nextLine());
                }
            } catch (Exception e) {
                System.out.println("Error while reading file: " + filePath);
            }
        }
    }
}

class FileScanner {
    private File[] files;
    private int current;

    public java_23767_FileScanner_A01(File dir, String pattern) {
        files = dir.listFiles((dir2, name) -> name.matches(pattern));
        if (files != null) {
            Arrays.sort(files, (file1, file2) -> file1.getName().compareTo(file2.getName()));
        }
        current = 0;
    }

    public boolean hasNext() {
        return files != null && current < files.length;
    }

    public String next() {
        return (files[current++]).getPath();
    }
}