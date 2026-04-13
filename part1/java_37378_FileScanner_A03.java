import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37378_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // Here we are assuming that this line is just a simple string. In a real scenario, you would not perform any injection attack here.
                            // However, for the purpose of the example, we are just printing the line to demonstrate the concept.
                            System.out.println(line);
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getPath());
                    }
                }
            }
        }
    }
}