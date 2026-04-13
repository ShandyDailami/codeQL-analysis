import java.io.File;
import java.util.ArrayList;

public class java_20600_FileScanner_A01 {

    private static final String ROOT_PATH = "C:/";

    private ArrayList<String> filePaths = new ArrayList<>();

    public ArrayList<String> scan() {
        File root = new File(ROOT_PATH);
        scanDirectory(root);
        return filePaths;
    }

    private void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // recursively scan subdirectories
                    scanDirectory(file);
                } else if (file.getName().endsWith(".txt")) {
                    // security-sensitive operation related to A01_BrokenAccessControl
                    // file access should be checked here
                    // for now, simply add file path to list
                    filePaths.add(file.getPath());
                }
            }
        }
    }

    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner();
        ArrayList<String> filePaths = scanner.scan();
        for (String path : filePaths) {
            System.out.println(path);
        }
    }
}