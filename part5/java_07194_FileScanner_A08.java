import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07194_FileScanner_A08 {

    private static class FileExtensionFilter implements FileFilter {
        private final String extension;

        public java_07194_FileScanner_A08(String extension) {
            this.extension = extension;
        }

        @Override
        public boolean accept(File pathname) {
            return pathname.getName().toLowerCase().endsWith(extension);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory!");
            return;
        }

        File[] files = directory.listFiles(new FileExtensionFilter(fileExtension));
        if (files == null) {
            System.out.println("No files found!");
            return;
        }

        System.out.println("Found the following files:");
        for (File file : files) {
            System.out.println(file.getPath());
        }
    }
}