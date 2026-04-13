import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35526_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory";  // replace with your directory
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
            if (files != null) {
                for (File file : files) {
                    if (file.exists()) {
                        Scanner scanner = new Scanner(file);
                        boolean containsAuthFailure = false;
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if (line.contains("A07_AuthFailure")) {
                                containsAuthFailure = true;
                                break;
                            }
                        }
                        if (containsAuthFailure) {
                            System.out.println("File: " + file.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }
}