import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_15187_FileScanner_A01 {
    private static final String FILTER_NAME = "*.txt"; // The filter to use for file selection
    private static final String ROOT_DIRECTORY = "/path/to/directory"; // Replace this with your directory

    public static void main(String[] args) {
        File rootDirectory = new File(ROOT_DIRECTORY);

        if (rootDirectory.exists() && rootDirectory.isDirectory()) {
            File[] files = rootDirectory.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".txt"); // Filter files by ending with .txt
                }
            });

            if (files != null) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter a name to search for in the files:");
                String searchName = scanner.nextLine();

                for (File file : files) {
                    if (file.getName().toLowerCase().contains(searchName)) {
                        System.out.println("Found file: " + file.getAbsolutePath());
                    }
                }

                scanner.close();
            } else {
                System.out.println("No files found in directory.");
            }
        } else {
            System.out.println("The specified directory does not exist or is not a directory.");
        }
    }
}