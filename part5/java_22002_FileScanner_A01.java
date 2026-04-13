import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class java_22002_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path

        try {
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                System.out.println("Directory does not exist.");
                return;
            }

            if (!directory.canRead()) {
                System.out.println("Directory does not have read permission.");
                return;
            }

            File[] files = directory.listFiles();
            if (files == null) {
                System.out.println("Listing files failed.");
                return;
            }

            Iterator<File> iterator = ((files != null) ? files : directory.listFiles()).iterator();
            while (iterator.hasNext()) {
                File file = iterator.next();
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}