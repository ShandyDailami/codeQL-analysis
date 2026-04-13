import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class java_32737_FileScanner_A01 {

    private static final String ROOT_DIRECTORY = "C:/";
    private static final String FILE_EXTENSION = ".*\\.java$";

    private List<String> filePaths = new ArrayList<>();

    public static void main(String[] args) {
        SecurityScanner scanner = new SecurityScanner();
        scanner.startScan(ROOT_DIRECTORY);
    }

    private void startScan(String directory) {
        File root = new File(directory);
        findFiles(root);
        for (String path : filePaths) {
            System.out.println("Scanning file: " + path);
            try {
                Scanner scanner = new Scanner(path);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains("package")) {
                        System.out.println("Suspicious line: " + line);
                    }
                }
                scanner.close();
            } catch (Exception e) {
                System.out.println("Error scanning file: " + path);
            }
        }
    }

    private void findFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    findFiles(file);
                } else if (file.getName().endsWith(".java")) {
                    filePaths.add(file.getAbsolutePath());
                }
            }
        }
    }
}