import java.io.*;

public class java_26239_FileScanner_A01 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // replace with actual directory path

        File dir = new File(dirPath);
        File[] listOfFiles = dir.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    // print the file name
                    System.out.println("File Name: " + file.getName());
                } else if (file.isDirectory()) {
                    // print the directory name
                    System.out.println("Directory Name: " + file.getName());
                }
            }
        } else {
            System.out.println("No files or directories found in " + dirPath);
        }
    }
}