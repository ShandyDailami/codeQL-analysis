import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01702_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.next();

        File directory = new File(directoryPath);

        FileFilter textFilesFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        findTextFiles(directory, textFilesFilter);
    }

    private static void findTextFiles(File directory, FileFilter filter) {
        File[] files = directory.listFiles(filter);
        if (files == null) return;

        for (File file : files) {
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Unable to read file: " + file.getAbsolutePath());
            }
        }
    }
}