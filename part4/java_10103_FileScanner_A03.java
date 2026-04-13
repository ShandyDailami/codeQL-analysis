import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10103_FileScanner_A03 {

    private static final String WORD_TO_SEARCH = "injection";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        File startingDirectory = new File(directoryPath);

        // Use a file filter to only scan directories, not files
        FileFilter fileFilter = (dir, name) -> dir.isDirectory();

        scanDirectory(startingDirectory, fileFilter, WORD_TO_SEARCH);
    }

    private static void scanDirectory(File dir, FileFilter fileFilter, String wordToSearch) {
        File[] foundFiles = dir.listFiles(fileFilter);

        if (foundFiles != null) {
            for (File file : foundFiles) {
                if (file.isFile() && containsWord(file, wordToSearch)) {
                    System.out.println("Found file: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    scanDirectory(file, fileFilter, wordToSearch);
                }
            }
        }
    }

    private static boolean containsWord(File file, String wordToSearch) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(wordToSearch)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}