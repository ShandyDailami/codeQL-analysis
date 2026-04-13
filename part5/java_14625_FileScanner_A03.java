import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_14625_FileScanner_A03 {

    private static final String SEPARATOR = File.separator;
    private static final String FILE_EXTENSION = ".*\\.java$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        String[] files = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.matches(FILE_EXTENSION);
            }
        });

        if (files != null) {
            Arrays.sort(files);
            for (String file : files) {
                System.out.println(dirPath + SEPARATOR + file);
            }
        } else {
            System.out.println("No .java files in the directory.");
        }
    }
}