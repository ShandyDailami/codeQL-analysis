import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_00586_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory not found!");
            System.exit(1);
        }

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };

        findTextFiles(directory, filter);
    }

    private static void findTextFiles(File directory, FilenameFilter filter) {
        File[] files = directory.listFiles(filter);

        if (files == null) {
            return;
        }

        Arrays.stream(files).forEach(file -> {
            if (file.isFile()) {
                System.out.println("Text file found: " + file.getAbsolutePath());
            } else {
                findTextFiles(file, filter);
            }
        });
    }
}