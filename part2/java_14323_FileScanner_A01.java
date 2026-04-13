import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14323_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            try {
                                Scanner scanner = new Scanner(file);
                                while (scanner.hasNextLine()) {
                                    String line = scanner.nextLine();
                                    System.out.println(line);
                                }
                                scanner.close();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } else {
                    System.out.println("No files in the directory!");
                }
            } else {
                System.out.println("The provided path is not a directory!");
            }
        } else {
            System.out.println("The provided directory does not exist!");
        }
    }
}