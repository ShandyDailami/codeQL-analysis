import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_11933_FileScanner_A07 {
    private static final String SECURITY_DIR = "/path/to/security/dir";

    public static void main(String[] args) {
        File securityDir = new File(SECURITY_DIR);
        List<File> authFailureFiles = getAuthFailureFiles(securityDir);
        for (File file : authFailureFiles) {
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains("A07_AuthFailure")) {
                        System.out.println("AuthFailure detected in: " + file.getPath());
                    }
                }
            } catch (Exception e) {
                System.out.println("Error processing file: " + file.getPath());
            }
        }
    }

    private static List<File> getAuthFailureFiles(File dir) {
        List<File> authFailureFiles = new ArrayList<>();
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String name = file.getName();
                        if (name.endsWith(".java")) {
                            authFailureFiles.add(file);
                        }
                    } else {
                        authFailureFiles.addAll(getAuthFailureFiles(file));
                    }
                }
            }
        }
        return authFailureFiles;
    }
}