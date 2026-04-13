import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.security.InvalidParameterException;

public class java_36090_FileScanner_A03 {
    private static final String[] IGNORED_FILES = new String[] { ".git", ".idea", ".DS_Store", "target", "node_modules" };

    public static void main(String[] args) throws IOException {
        File root = new File("/path/to/root/directory");
        if (!root.exists()) {
            throw new InvalidParameterException("Root directory does not exist!");
        }

        FileVisitor fileVisitor = new FileVisitor(root, IGNORED_FILES);
        fileVisitor.visit(root);
    }

    private static class FileVisitor implements java.io.FileVisitor {
        private File root;
        private String[] ignoredFiles;

        public java_36090_FileScanner_A03(File root, String[] ignoredFiles) {
            this.root = root;
            this.ignoredFiles = ignoredFiles;
        }

        @Override
        public boolean visit(File file) {
            if (file.isDirectory()) {
                if (file.listFiles(new java.io.FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        // accept only files and directories
                        return (pathname.isFile() || pathname.isDirectory());
                    }
                }).length == 0) {
                // if directory is empty, print its name
                System.out.println("Empty directory: " + file.getPath());
            } else if (!isIgnored(file)) {
                // print file name and size
                System.out.println("File: " + file.getPath() + ", size: " + file.length());
            }
            return true; // continue traversal
        }

        @Override
        public boolean visitFileFailed(File file, String name) {
            System.out.println("Failed to visit file: " + file.getPath());
            return true;
        }

        private boolean isIgnored(File file) {
            for (String ignoredFile : ignoredFiles) {
                if (file.getPath().equals(ignoredFile)) {
                    return true;
                }
            }
            return false;
        }
    }
}