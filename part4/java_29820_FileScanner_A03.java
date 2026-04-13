import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_29820_FileScanner_A03 {
    // The file to start the scan from.
    private File startDir;

    // The file visitor to process each file.
    private FileVisitor fileVisitor;

    public java_29820_FileScanner_A03(File startDir, FileVisitor fileVisitor) {
        this.startDir = startDir;
        this.fileVisitor = fileVisitor;
    }

    public void scan() throws IOException {
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // No filter, accept all files.
                return true;
            }
        };

        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                // No filter, accept all file names.
                return true;
            }
        };

        scan(startDir, fileFilter, filenameFilter);
    }

    private void scan(File dir, FileFilter fileFilter, FilenameFilter filenameFilter) throws IOException {
        File[] files = dir.listFiles(fileFilter);
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                scan(file, fileFilter, filenameFilter);
            } else {
                fileVisitor.visit(file);
            }
        }
    }

    public interface FileVisitor {
        void visit(File file);
    }
}