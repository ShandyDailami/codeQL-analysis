import java.io.*;
import java.util.*;

public class java_06545_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        File file = new File(".");
        File[] list = file.listFiles();
        
        if(list != null) {
            for(File f : list) {
                if(f.isFile() && f.getName().endsWith(".log")) {
                    System.out.println("Found log file: " + f.getName());
                    printFileContents(f);
                }
            }
        }
    }

    private static void printFileContents(File file) throws IOException {
        FileReader reader = new FileReader(file);
        int content;
        while((content = reader.read()) != -1) {
            System.out.print((char)content);
        }
        reader.close();
    }
}