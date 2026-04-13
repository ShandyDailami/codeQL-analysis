import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class java_09410_FileScanner_A01 {

    private final String directoryPath;
    private final String fileExtension;

    public java_09410_FileScanner_A01(String directoryPath, String fileExtension) {
        this.directoryPath = directoryPath;
        this.fileExtension = fileExtension;
    }

    public void scan() {
        File directory = new File(directoryPath);
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : Objects.requireNonNull(listOfFiles)) {
                if (file.isFile() && file.getName().endsWith(fileExtension)) {
                    System.out.println(file.getPath());
                }
            }
        }
    }

    public static void main(String[] args) {
        String directoryPath = "path_to_directory"; // replace with your directory path
        String fileExtension = ".txt"; // replace with your file extension

        FileScanner scanner = new FileScanner(directoryPath, fileExtension);
        scanner.scan();
    }
}