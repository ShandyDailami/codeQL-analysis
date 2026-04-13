import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40982_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "your_directory_path"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                System.out.println(line);
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.println("No files in directory.");
            }
        } else {
            System.out.println("Invalid directory.");
        }
    }
}