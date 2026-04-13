import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14358_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        Scanner scanner = null;
                        try {
                            scanner = new Scanner(file);
                            int lineCount = 0;
                            while (scanner.hasNextLine()) {
                                scanner.nextLine();
                                lineCount++;
                            }
                            System.out.println("Number of lines in file " + file.getName() + ": " + lineCount);
                        } catch (FileNotFoundException e) {
                            System.out.println("Error reading file " + file.getName());
                        } finally {
                            if (scanner != null) {
                                scanner.close();
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}