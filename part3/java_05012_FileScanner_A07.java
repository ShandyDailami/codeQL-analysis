import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_05012_FileScanner_A07 {
    public static void main(String[] args) {
        File rootDir = new File("."); // current directory
        String fileExtension = "txt";

        File[] textFiles = rootDir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isFile() && pathname.getName().endsWith("." + fileExtension)) {
                    return true;
                }
                return false;
            }
        });

        if (textFiles != null) {
            Arrays.sort(textFiles, String.CASE_INSENSITIVE_ORDER);
            for (File file : textFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No text files found in the directory.");
        }
    }
}