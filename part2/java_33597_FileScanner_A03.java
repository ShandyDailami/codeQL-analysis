import java.io.File;

public class java_33597_FileScanner_A03 {
    public static void main(String[] args) {
        // Get the current directory
        File currentDir = new File(".");

        // List all files in the current directory
        File[] files = currentDir.listFiles();

        // Check if there are any files in the current directory
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}