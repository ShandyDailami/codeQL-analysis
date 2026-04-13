import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_28804_FileScanner_A03 {

    private static final String FOLDER_PATH = "./target";
    private static final String SEARCH_CONTENT = "A03_Injection";

    public static void main(String[] args) {
        File folder = new File(FOLDER_PATH);
        scanFolder(folder, SEARCH_CONTENT);
    }

    private static void scanFolder(File folder, String content) {
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                if (containsInjection(file, content)) {
                    System.out.println("File: " + file.getAbsolutePath() + " contains injection!");
                }
            } else if (file.isDirectory()) {
                scanFolder(file, content);
            }
        }
    }

    private static boolean containsInjection(File file, String content) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(content)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}