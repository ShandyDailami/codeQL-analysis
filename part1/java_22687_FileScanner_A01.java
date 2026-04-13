import java.io.File;
import java.io.IOException;
import java.security.Permission;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_22687_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            List<String> fileNames = getFiles(".", new SecurityManager());
            for (String fileName : fileNames) {
                System.out.println(fileName);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static List<String> getFiles(String directory, SecurityManager securityManager) throws IOException {
        File file = new File(directory);
        List<String> fileNames = new ArrayList<>();

        if (!file.exists()) {
            throw new IllegalArgumentException("Directory does not exist: " + directory);
        }

        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return fileNames;
        }

        for (File f : listFiles) {
            if (f.isDirectory()) {
                fileNames.addAll(getFiles(f.getAbsolutePath(), securityManager));
            } else {
                fileNames.add(f.getAbsolutePath());
            }
        }

        return fileNames;
    }

    private static class SecurityManager extends java.security.SecurityManager {
        @Override
        public void checkPermission(Permission perm) {
            // Do nothing, but ensure that checkPermission is not called by security managers
        }

        @Override
        public void checkExit(int status) {
            // Do nothing, but ensure that checkExit is not called by security managers
        }
    }
}