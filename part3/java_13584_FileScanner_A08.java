import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13584_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File(".");
        String name = "A08_IntegrityFailure";
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().contains(name);
            }
        };

        SecurityManager securityManager = new SecurityManager() {
            public boolean getSecurityManagerPermission(java.security.BasicPermission basicPermission) {
                return true;
            }
        };

        try {
            FileScanner scanner = new FileScanner(directory, fileFilter, securityManager);
            scanner.scan();
        } catch (SecurityException e) {
            System.out.println("FileScanner was not permitted to access the specified directory.");
        } catch (FileNotFoundException e) {
            System.out.println("FileScanner could not find the specified directory.");
        }
    }
}

class FileScanner {
    private File directory;
    private FileFilter fileFilter;
    private SecurityManager securityManager;

    public java_13584_FileScanner_A08(File directory, FileFilter fileFilter, SecurityManager securityManager) {
        this.directory = directory;
        this.fileFilter = fileFilter;
        this.securityManager = securityManager;
    }

    public void scan() throws SecurityException, FileNotFoundException {
        File[] files = directory.listFiles(fileFilter);
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    processFile(file);
                }
            }
        } else {
            throw new FileNotFoundException();
        }
    }

    private void scanDirectory(File directory) throws SecurityException {
        File[] files = directory.listFiles(fileFilter);
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    processFile(file);
                }
            }
        } else {
            throw new SecurityException();
        }
    }

    private void processFile(File file) {
        // Implement file processing here
    }
}