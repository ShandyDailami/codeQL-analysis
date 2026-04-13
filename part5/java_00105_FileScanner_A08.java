import java.io.File;

public class java_00105_FileScanner_A08 {
    public static void main(String[] args) {
        // Get the current directory
        File currentDir = new File(".");

        // List all files in the current directory
        File[] listOfFiles = currentDir.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            }
        }
    }
}