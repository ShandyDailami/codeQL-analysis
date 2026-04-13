import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36879_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        String dirPath = "your_directory_path"; // replace with your directory path
        File dir = new File(dirPath);

        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        System.out.println("Reading file: " + file.getName());
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                        scanner.close();
                    }
                }
            } else {
                System.out.println("No files in directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}