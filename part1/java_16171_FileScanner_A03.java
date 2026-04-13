import java.io.File;
import java.util.Arrays;

public class java_16171_FileScanner_A03 {

    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // replace with your directory path
        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] txtFiles = dir.listFiles((dir1, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                Arrays.stream(txtFiles)
                      .map(File::getName)
                      .forEach(System.out::println);
            } else {
                System.out.println("No .txt files found in directory.");
            }
        } else {
            System.out.println("The specified directory does not exist or it is not a directory.");
        }
    }
}