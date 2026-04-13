import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_30851_FileScanner_A03 {
    private static final String FILE_PATH = "/path/to/directory/";  // Replace this with the directory you want to scan

    public static void main(String[] args) {
        File file = new File(FILE_PATH);
        Scanner scanner = new Scanner(System.in);

        if (file.exists()) {
            System.out.println("Enter the file extension to search for (e.g. '.txt'):");
            String extension = scanner.next();

            String[] files = file.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(extension);
                }
            });

            System.out.println("Files with extension " + extension + ": " + Arrays.toString(files));
        } else {
            System.out.println("File does not exist.");
        }

        scanner.close();
    }
}