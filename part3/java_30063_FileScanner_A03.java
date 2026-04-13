import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_30063_FileScanner_A03 {

    public static void main(String[] args) {
        File dir = new File(".");
        File[] listOfFiles = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });

        if(listOfFiles != null) {
            for(File file : listOfFiles) {
                System.out.println("File Name: " + file.getName());
                System.out.println("File Path: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found!");
        }
    }
}