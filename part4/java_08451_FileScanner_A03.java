import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08451_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/your/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    System.out.println(txtFile.getName());
                }
            } else {
                System.out.println("No .txt files found.");
            }
        } else {
            System.out.println("Directory not found.");
        }
    }
}