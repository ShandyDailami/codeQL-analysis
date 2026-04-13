import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20076_FileScanner_A07 {

    public static void main(String[] args) {
        File rootDir = new File(".");
        searchFiles(rootDir, "auth");
    }

    public static void searchFiles(File dir, String keyword) {
        File[] listOfFiles = dir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    searchFiles(file, keyword);
                } else if (file.getName().contains(keyword)) {
                    try {
                        handleFile(file, keyword);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        });
    }

    public static void handleFile(File file, String keyword) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(keyword)) {
                System.out.println("Found 'auth' in file: " + file.getPath());
            }
        }
        scanner.close();
    }
}