import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21552_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        System.out.println("File: " + file.getAbsolutePath());

                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println("Line: " + line);
                        }
                        scanner.close();
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist!");
        }
    }
}