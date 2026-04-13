import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_04269_FileScanner_A08 {
    private static String targetExtension;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter target file extension:");
        targetExtension = scanner.nextLine();

        String directoryPath = "."; // Use the current directory.
        fileScan(new File(directoryPath));
    }

    private static void fileScan(File directory) {
        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("." + targetExtension);
            }
        });

        if (files != null) {
            Arrays.stream(files).forEach(file -> fileScan(file));
        }
    }
}