import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class java_23782_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(".txt"));

        if (files != null) {
            for (File file : files) {
                try (FileReader reader = new FileReader(file)) {
                    int r;
                    while ((r = reader.read()) != -1) {
                        // This is a security-sensitive operation.
                        if (r == 1) { // Replace 1 with whatever operation you want to test for failure.
                            System.out.println("Security failure detected in file: " + file.getPath());
                            // The next operations depends on the specific security failures.
                            // Here I'm just removing the file.
                            file.delete();
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getPath());
                } catch (IOException e) {
                    System.out.println("Error reading file: " + file.getPath());
                }
            }
        }
    }
}