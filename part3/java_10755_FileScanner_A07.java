import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10755_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                int lineCount = 0;
                for (File file : files) {
                    if (file.isFile()) {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            lineCount++;
                            scanner.nextLine();
                        }
                        scanner.close();
                    }
                }
                System.out.println("Total lines in files: " + lineCount);
            } else {
                System.out.println("Directory is empty");
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }
}