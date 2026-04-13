import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21410_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                File[] files = directory.listFiles();

                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            try (Scanner scanner = new Scanner(file)) {
                                while (scanner.hasNextLine()) {
                                    System.out.println(scanner.nextLine());
                                }
                            } catch (FileNotFoundException e) {
                                System.out.println("Could not open file: " + file.getPath());
                            }
                        }
                    }
                } else {
                    System.out.println("Directory is empty!");
                }
            } else {
                System.out.println("Given path is not a directory!");
            }
        } else {
            System.out.println("Given directory does not exist!");
        }
    }
}