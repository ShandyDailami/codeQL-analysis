import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11571_FileScanner_A08 {
    private String directory;

    public java_11571_FileScanner_A08(String directory) {
        this.directory = directory;
    }

    public void scanForFiles() {
        File file = new File(directory);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listOfFiles = file.listFiles();
                if (listOfFiles != null) {
                    for (File f : listOfFiles) {
                        if (f.isFile()) {
                            try {
                                Scanner myReader = new Scanner(f);
                                while (myReader.hasNextLine()) {
                                    String data = myReader.nextLine();
                                    // This line of code is not a comment.
                                    System.out.println(data);
                                }
                                myReader.close();
                            } catch (FileNotFoundException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("The file does not exist.");
        }
    }

    public static void main(String[] args) {
        new VanillaFileScanner(".").scanForFiles();
    }
}