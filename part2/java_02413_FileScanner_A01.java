import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class java_02413_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            System.exit(1);
        }

        if (!directory.isDirectory()) {
            System.out.println("Provided path is not a directory.");
            System.exit(1);
        }

        FileFilter textFilesFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        File[] textFiles = directory.listFiles(textFilesFilter);

        if (textFiles == null) {
            System.out.println("No text files found in the directory.");
            System.exit(1);
        }

        System.out.println("Text files in the directory:");

        for (File textFile : textFiles) {
            System.out.println(textFile.getName());

            FileScanner fileScanner = new FileScanner(textFile);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println("   - " + line);
            }

            fileScanner.close();
        }
    }
}