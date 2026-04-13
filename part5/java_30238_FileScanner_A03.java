import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30238_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        File rootDirectory = new File(".");
        String targetString = "password";

        FileFilter textFilesFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the target string:");
        targetString = scanner.nextLine();

        findFilesWithTargetString(rootDirectory, textFilesFilter, targetString);
    }

    private static void findFilesWithTargetString(File rootDirectory, FileFilter textFilesFilter, String targetString) throws FileNotFoundException {
        File[] filesWithTargetString = rootDirectory.listFiles(textFilesFilter);

        for (File file : filesWithTargetString) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(targetString)) {
                    System.out.println("File: " + file.getPath() + " Contains target string.");
                }
            }
        }
    }
}