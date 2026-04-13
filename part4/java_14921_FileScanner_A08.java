import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14921_FileScanner_A08 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with your directory
        String extension = ".txt"; // replace with your file extension

        File dir = new File(directory);

        File[] listOfFiles = dir.listFiles((dir1, name) -> name.endsWith(extension));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                try {
                    Scanner myReader = new Scanner(file);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred while reading the file.");
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No files found with the provided extension in the directory.");
        }
    }
}