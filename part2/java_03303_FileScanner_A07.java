import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class java_03303_FileScanner_A07 {
    private static final String DIRECTORY = "path_to_your_directory"; // replace with your directory
    private static final String FILE_EXTENSION = ".txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name:");
        String fileName = scanner.next();

        File directory = new File(DIRECTORY);

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().equals(fileName) && pathname.isFile() && pathname.getName().endsWith(FILE_EXTENSION);
            }
        };

        File[] files = directory.listFiles(filter);

        if (files == null || files.length == 0) {
            System.out.println("No file found with name: " + fileName + " and extension: " + FILE_EXTENSION);
        } else {
            System.out.println("File found: " + files[0].getAbsolutePath());
        }
    }
}