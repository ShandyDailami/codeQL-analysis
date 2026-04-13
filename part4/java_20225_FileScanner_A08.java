import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_20225_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the extension:");
        String extension = scanner.nextLine();

        File directory = new File(directoryPath);

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("." + extension);
            }
        };

        File[] textFiles = directory.listFiles(filter);

        if (textFiles != null) {
            Arrays.sort(textFiles, String.CASE_INSENSITIVE_ORDER);
            for (File textFile : textFiles) {
                if (textFile.isFile() && textFile.canRead()) {
                    System.out.println(textFile.getName());
                }
            }
        } else {
            System.out.println("No text files found in directory.");
        }
    }
}