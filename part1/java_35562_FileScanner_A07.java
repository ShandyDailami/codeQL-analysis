import java.io.*;
import java.util.*;

public class java_35562_FileScanner_A07 {

    public static void main(String[] args) {
        File file = new File(".");

        // FileNotFoundException is a checked exception. 
        // Let's try to read a file.
        try (FileReader reader = new FileReader(file)) {
            int r;
            while ((r = reader.read()) != -1) {
                System.out.print((char) r);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}