import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16513_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String filter = ".txt"; // replace with your file extension

        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(filter));

            if (files != null) {
                for (File file : files) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("No files with the filter found in the directory.");
            }
        } else {
            System.out.println("The provided path is not a directory.");
        }
    }
}