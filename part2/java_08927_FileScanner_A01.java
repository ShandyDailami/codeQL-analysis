import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08927_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File("path_to_directory");
        printFilesInDirectory(directory);
    }

    public static void printFilesInDirectory(File directory) throws FileNotFoundException {
        File[] listOfFiles = directory.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                Scanner myReader = new Scanner(listOfFiles[i]);
                System.out.println("File: " + listOfFiles[i].getName());
                while (myReader.hasNextLine()) {
                    String line = myReader.nextLine();
                    System.out.println(line);
                }
                myReader.close();
            }
        }
    }
}