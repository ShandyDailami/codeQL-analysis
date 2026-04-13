import java.io.File;
import java.util.Arrays;

public class java_03376_FileScanner_A01 {
    public static void main(String[] args) {
        String directory = "/path/to/directory";

        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            Arrays.stream(listOfFiles)
                    .filter(file -> !file.isHidden() && !file.getName().startsWith("."))
                    .forEach(Main::printFileDetails);
        }
    }

    private static void printFileDetails(File file) {
        if (file.isFile()) {
            System.out.println("File: " + file.getName());
        } else {
            System.out.println("Directory: " + file.getName());
        }
    }
}