import java.io.File;
import java.util.Arrays;

public class java_17229_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "C:\\temp";  // Replace with your directory path
        String extension = ".txt";  // Replace with your extension

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(extension));

            if (txtFiles != null) {
                Arrays.stream(txtFiles).forEach(file -> System.out.println(file.getAbsolutePath()));
            } else {
                System.out.println("No .txt files found in the directory.");
            }
        } else {
            System.out.println("Invalid directory.");
        }
    }
}