import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_41285_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        try {
            File dir = new File(dirPath);
            if (!dir.exists()) {
                System.out.println("Directory does not exist!");
                return;
            }

            File[] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    File file = new File(dir, name);
                    return file.isFile() && file.canRead();
                }
            });

            if (files == null) {
                System.out.println("Unable to read directory!");
                return;
            }

            Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
        } catch (SecurityException e) {
            System.out.println("Access denied: " + e.getMessage());
        }
    }
}