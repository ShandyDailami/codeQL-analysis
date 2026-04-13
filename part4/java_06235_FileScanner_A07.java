import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class java_06235_FileScanner_A07 {
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");

        // Get all files in the current directory
        File dir = new File(currentDir);
        File[] listOfFiles = dir.listFiles();

        List<String> fileNames = new ArrayList<>();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                fileNames.add(file.getName());
            }
        }

        // Print out the file names
        for (String name : fileNames) {
            System.out.println(name);
        }
    }
}