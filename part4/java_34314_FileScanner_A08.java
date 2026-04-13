import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class java_34314_FileScanner_A08 {
    public static void main(String[] args) {
        String directory = "path/to/directory"; // Replace with your directory path
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the file size (in bytes):");
        int size = scanner.nextInt();

        File dir = new File(directory);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.canExecute() && file.length() > size) {
                    try (FileReader reader = new FileReader(file)) {
                        int c;
                        while ((c = reader.read()) != -1) {
                            System.out.print((char) c);
                        }
                        System.out.println();
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + file.getPath());
                    }
                }
            }
        } else {
            System.out.println("Error getting file list");
        }

        scanner.close();
    }
}