import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09394_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "src/main/resources"; // Use your directory path here
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                        scanner.close();
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}