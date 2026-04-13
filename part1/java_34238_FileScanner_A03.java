import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34238_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        File folder = new File("path_to_directory");
        scanDirectory(folder);
    }

    private static void scanDirectory(File folder) throws FileNotFoundException {
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    printFileContent(file);
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }

    private static void printFileContent(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }
}