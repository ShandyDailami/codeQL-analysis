import java.io.File;
import java.util.Arrays;

public class java_31935_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File("."); // Current directory

        if (directory.exists()) {
            File[] listOfFiles = directory.listFiles();

            if (listOfFiles != null) {
                Arrays.stream(listOfFiles)
                      .filter(file -> !file.isDirectory())
                      .map(File::getName)
                      .forEach(System.out::println);
            } else {
                System.out.println("No files in current directory!");
            }
        } else {
            System.out.println("Directory does not exist!");
        }
    }
}