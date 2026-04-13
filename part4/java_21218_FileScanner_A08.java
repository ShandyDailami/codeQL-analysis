import java.io.*;

public class java_21218_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File(".");
        File[] listOfFiles = directory.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println("File Name: " + file.getName());
                System.out.println("Absolute Path: " + file.getAbsolutePath());
                System.out.println("File Size: " + file.length() + " bytes");
            } else if (file.isDirectory()) {
                System.out.println("Directory Name: " + file.getName());
            }
        }
    }
}