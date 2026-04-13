import java.io.*;

public class java_36020_FileScanner_A01 {
    public static void main(String[] args) {
        File rootDirectory = new File(".");
        File[] txtFiles = rootDirectory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                System.out.println("File: " + txtFile.getAbsolutePath());
            }
        } else {
            System.out.println("No .txt files in the root directory.");
        }
    }
}