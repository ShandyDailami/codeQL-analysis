import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_22880_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        File directory = new File(".");
        String[] files = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });
        if (files != null) {
            for (String file : files) {
                File fileObj = new File(file);
                if (fileObj.canRead()) {
                    System.out.println("File: " + fileObj.getAbsolutePath());
                } else {
                    System.out.println("Unable to read file: " + fileObj.getAbsolutePath());
                }
            }
        } else {
            System.out.println("No .txt files found in the current directory.");
        }
    }
}