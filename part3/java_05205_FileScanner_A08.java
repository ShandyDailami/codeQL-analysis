import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05205_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory"; // provide your directory path here
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        try {
            Scanner scanner = new Scanner(directory);
            while (scanner.hasNext()) {
                File file = new File(directoryPath + "/" + scanner.nextLine());
                if (file.exists()) {
                    System.out.println("File name: " + file.getName());
                    System.out.println("File path: " + file.getAbsolutePath());
                } else {
                    System.out.println("File does not exist");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}