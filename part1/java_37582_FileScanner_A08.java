import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_37582_FileScanner_A08 {

    public static void main(String[] args) {
        String directory = "/path/to/directory"; // Replace with your directory path

        try {
            FileScanner(directory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void FileScanner(String directory) throws IOException {
        File file = new File(directory);

        if (file.exists()) {
            File[] files = file.listFiles();

            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    Path path = Paths.get(files[i].getPath());
                    long size = Files.size(path);
                    System.out.println("File name: " + files[i].getName());
                    System.out.println("File size: " + size + " bytes");
                } else if (files[i].isDirectory()) {
                    System.out.println("Directory: " + files[i].getName());
                }
            }
        } else {
            System.out.println("Directory not found!");
        }
    }
}