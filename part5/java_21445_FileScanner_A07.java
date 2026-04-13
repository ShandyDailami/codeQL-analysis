import java.io.*;

public class java_21445_FileScanner_A07 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // replace with your directory path
        String searchWord = "A07_AuthFailure"; // replace with your search word

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().contains(searchWord)) {
                        System.out.println("File: " + file.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist or it's not a directory.");
        }
    }
}