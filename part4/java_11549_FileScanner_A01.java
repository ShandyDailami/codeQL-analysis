import java.io.*;
import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.security.GuardianSelector;

public class java_11549_FileScanner_A01 {
    private File file;
    private FileFilter fileFilter;

    public java_11549_FileScanner_A01(File file, FileFilter fileFilter) {
        this.file = file;
        this.fileFilter = fileFilter;
    }

    public void scan() {
        try {
            scanFile(file, fileFilter);
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }
    }

    private void scanFile(File file, FileFilter fileFilter) throws AccessDeniedException {
        File[] foundFiles;
        if (file.isDirectory()) {
            foundFiles = file.listFiles(fileFilter);
            if (foundFiles == null)
                throw new AccessDeniedException("Access to directory is denied.");
            for (File f : foundFiles) {
                scanFile(f, fileFilter);
            }
        } else {
            foundFiles = new File[0];
            if (file.canRead()) {
                foundFiles = file.getParentFile().listFiles(fileFilter);
            }
        }

        for (File f : foundFiles) {
            System.out.println("Found file: " + f.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        File file = new File(".");
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(Path path) {
                return path.toString().endsWith(".txt");
            }
        };
        new BrokenFileScanner(file, fileFilter).scan();
    }
}