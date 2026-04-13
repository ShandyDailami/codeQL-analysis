import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_38696_FileScanner_A07 {
    public static void main(String[] args) {
        String directory = "path_to_directory";
        File folder = new File(directory);

        // Ensure the directory exists
        if (!folder.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        // Ensure the directory is a directory
        if (!folder.isDirectory()) {
            System.out.println("Provided path is not a directory");
            return;
        }

        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                try {
                    Scanner myReader = new Scanner(file);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred while trying to read the file");
                    e.printStackTrace();
                }
            }
        }
    }
}