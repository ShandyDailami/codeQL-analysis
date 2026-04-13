import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17132_FileScanner_A03 {

    private final String directoryPath;
    private final String[] safeFileNames;

    public java_17132_FileScanner_A03(String directoryPath, String[] safeFileNames) {
        this.directoryPath = directoryPath;
        this.safeFileNames = safeFileNames;
    }

    public void scanDirectory() {
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory");
            return;
        }

        File[] safeFiles = directory.listFiles((dir, name) -> ArrayUtils.contains(safeFileNames, name));
        if (safeFiles != null) {
            for (File file : safeFiles) {
                if (file.isFile()) {
                    System.out.println("Found safe file: " + file.getName());
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory";
        String[] safeFileNames = {"safe1.txt", "safe2.txt"};
        FileScanner scanner = new FileScanner(directoryPath, safeFileNames);
        scanner.scanDirectory();
    }
}