import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;

public class java_16743_FileScanner_A01 {
    private String directoryPath;

    public java_16743_FileScanner_A01(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void scan(String extension) {
        File dir = new File(directoryPath);

        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        });

        if (files != null) {
            for (File file : files) {
                try {
                    SecurityManager sm = new SecurityManager() {
                        public void checkRead(File file) throws SecurityException {
                            // This method can be used to read files.
                            // In a real-world application, this would be replaced with
                            // a more secure method that verifies the file's permissions.
                        }

                        public void checkDelete(File file) throws SecurityException {
                            // This method can be used to delete files.
                            // In a real-world application, this would be replaced with
                            // a more secure method that verifies the file's permissions.
                        }
                    };
                    sm.checkRead(file);
                    sm.checkDelete(file);

                    System.out.println("File: " + file.getAbsolutePath());
                } catch (SecurityException e) {
                    System.out.println("Access denied for file: " + file.getAbsolutePath());
                }
            }
        }
    }

    public static void main(String[] args) {
        new SecurityFileScanner(".").scan(".txt");
    }
}