import java.io.File;
import java.io.IOException;

public class java_18147_FileScanner_A08 {
    public static void main(String[] args) {
        // Specify the directory to search
        File directory = new File("C:\\path\\to\\your\\directory");

        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    // Print the name and size of each file
                    System.out.println("File name: " + file.getName());
                    System.out.println("File size: " + file.length() + " bytes");
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            }
        }
    }
}