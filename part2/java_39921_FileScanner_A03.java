import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39921_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with actual directory path
        String fileType = "txt";  // replace with actual file type

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(fileType));

            if (files != null) {
                for (File file : files) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);  // replace with actual security-sensitive operation
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files of type: " + fileType + " in directory: " + directory.getName());
            }
        } else {
            System.out.println("Directory not found: " + directoryPath);
        }
    }
}