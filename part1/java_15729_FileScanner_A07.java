import java.io.File;
import java.io.FilenameFilter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_15729_FileScanner_A07 {
    private Set<String> fileNames = new HashSet<>();

    public java_15729_FileScanner_A07() {
        this(".");
    }

    public java_15729_FileScanner_A07(String directory) {
        scan(directory);
    }

    private void scan(String directory) {
        File rootDirectory = new File(directory);
        if (rootDirectory.isDirectory()) {
            File[] files = rootDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        scan(file.getAbsolutePath());
                    } else {
                        processFile(file);
                    }
                }
            }
        }
    }

    private void processFile(File file) {
        if (file.isFile() && isFileSecure(file)) {
            fileNames.add(file.getAbsolutePath());
        }
    }

    private boolean isFileSecure(File file) {
        // This function could be used to implement some security-sensitive operation related to A07_AuthFailure.
        // For the purpose of this example, we just return true to simulate the operation.
        return true;
    }

    public Set<String> getFileNames() {
        return fileNames;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory:");
        String directory = scanner.nextLine();
        SecureFileScanner scanner1 = new SecureFileScanner(directory);
        Set<String> fileNames = scanner1.getFileNames();
        for (String name : fileNames) {
            System.out.println(name);
        }
    }
}