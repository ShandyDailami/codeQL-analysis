import java.io.File;
import java.util.Scanner;

public class java_33492_FileScanner_A03 {
    private static final String DIRECTORY_PATH = "path/to/directory";
    private static final String SEARCH_STRING = "search_string";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username:");
        String username = scanner.nextLine();

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().contains(username)) {
                    System.out.println("File name: " + file.getName());
                }
            }
        }

        scanner.close();
    }
}