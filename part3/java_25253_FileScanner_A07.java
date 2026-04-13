import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25253_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        String searchString = "AuthFailure";
        File dir = new File(directoryPath);

        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        File[] files = dir.listFiles(filter);

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    boolean containsAuthFailure = false;
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.contains(searchString)) {
                            containsAuthFailure = true;
                            break;
                        }
                    }
                    if (!containsAuthFailure) {
                        System.out.println("File: " + file.getPath() + " does not contain the string " + searchString);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}