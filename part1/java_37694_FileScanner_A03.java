import java.io.File;
import java.util.Scanner;

public class java_37694_FileScanner_A03 {

    private static final String TARGET_DIR = "C:\\temp";

    public static void main(String[] args) {
        File dir = new File(TARGET_DIR);
        String[] files = dir.list();

        if (files != null) {
            for (String file : files) {
                File fileObj = new File(dir.getPath(), file);

                if (fileObj.isFile()) {
                    if (isFileInjected(fileObj)) {
                        System.out.println("File: " + fileObj.getPath() + " is injected");
                    } else {
                        System.out.println("File: " + fileObj.getPath() + " is not injected");
                   
                    }
                } else if (fileObj.isDirectory()) {
                    System.out.println("Directory: " + fileObj.getPath());
                }
            }
        }
    }

    private static boolean isFileInjected(File file) {
        // This is a placeholder, the real function is not specified
        return false;
    }
}