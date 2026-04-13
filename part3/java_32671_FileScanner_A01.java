import java.io.*;
import java.util.*;

public class java_32671_FileScanner_A01 {
    public static void main(String[] args) {
        // FileScanner creates a new FileScanner instance to scan a directory
        // with a given name. The files in the directory are sorted by name.
        FileScanner fs = new FileScanner("C:/testDir/", ".*\\.txt");

        // Scanning the directory
        fs.scan();

        // Printing all the file names in the directory
        System.out.println("File names in the directory:");
        while (fs.hasNext()) {
            System.out.println(fs.nextFile());
        }

        // Closing the scanner
        fs.close();
    }
}