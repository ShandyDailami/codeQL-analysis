import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_36453_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file: ");
        String fileName = scanner.nextLine();
        System.out.print("Enter the extension of the file (without dot): ");
        String extension = scanner.nextLine();
        File rootDirectory = new File(".");
        findFile(rootDirectory, fileName, extension);
    }

    private static void findFile(File directory, String fileName, String extension) {
        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(extension.toLowerCase());
            }
        });
        if (files != null) {
            Arrays.stream(files).forEach(file -> {
                if (file.isFile()) {
                    if (file.getName().toLowerCase().endsWith(fileName.toLowerCase())) {
                        System.out.println("File found: " + file.getAbsolutePath());
                    }
                } else {
                    findFile(file, fileName, extension);
                }
            });
        }
    }
}