import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30932_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        String fileType = "txt";  // replace with your file type

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(fileType));

            if (files != null) {
                for (File file : files) {
                    try {
                        Scanner scanner = new Scanner(file);
                        scanner.useDelimiter("\\Z");
                        boolean isEmpty = scanner.hasNext();

                        if (!isEmpty) {
                            System.out.println("File: " + file.getPath() + " is empty");
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File: " + file.getPath() + " not found");
                    }
                }
            }
        } else {
            System.out.println("Directory: " + directoryPath + " not found or not a directory");
        }
    }
}