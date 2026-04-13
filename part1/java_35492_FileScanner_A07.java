import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35492_FileScanner_A07 {
    private static final String DIRECTORY = "/path/to/directory"; // replace with your directory
    private static final long MAX_FILE_SIZE = 1024L; // replace with your file size

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.length() > MAX_FILE_SIZE) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("Unable to read file: " + file.getAbsolutePath());
                    }
                }
            }
        }
    }
}