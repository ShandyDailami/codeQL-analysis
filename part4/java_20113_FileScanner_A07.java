import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20113_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {

        File directory = new File("."); // get current directory
        File[] listOfFiles = directory.listFiles();

        if(listOfFiles != null) {
            for(File file : listOfFiles) {
                if(file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}