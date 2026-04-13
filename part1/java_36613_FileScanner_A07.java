import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_36613_FileScanner_A07 {

    public static void main(String[] args) {
        // create a new scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");

        // read the directory path
        String directoryPath = scanner.nextLine();

        // get all files in the directory
        List<File> files = getFilesInDirectory(directoryPath);

        // print the file names
        for (File file : files) {
            System.out.println(file.getName());
        }

        // close the scanner
        scanner.close();
    }

    private static List<File> getFilesInDirectory(String directoryPath) {
        // create a new file object
        File directory = new File(directoryPath);

        // get all files in the directory
        File[] files = directory.listFiles();

        // create a list to hold the files
        List<File> fileList = new ArrayList<>();

        // add each file to the list
        for (File file : files) {
            if (file.isFile()) {
                fileList.add(file);
            }
        }

        // return the list
        return fileList;
    }
}