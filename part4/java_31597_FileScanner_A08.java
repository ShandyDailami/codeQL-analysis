import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31597_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "path/to/directory"; // replace with your directory path

        File directory = new File(directoryPath);

        FileFilter textFiles = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().toLowerCase().endsWith(".txt");
            }
        };

        try {
            File[] textFilesInDirectory = directory.listFiles(textFiles);

            if (textFilesInDirectory != null) {
                for (File file : textFilesInDirectory) {
                    if (!file.canRead()) {
                        System.out.println("File " + file.getPath() + " is not readable. Permission denied.");
                        continue;
                    }

                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                    }

                    fileScanner.close();
                }
            } else {
                System.out.println("No text files in directory.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}