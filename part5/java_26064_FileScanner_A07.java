import java.io.File;
import java.util.Scanner;

public class java_26064_FileScanner_A07 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.setDirectory("path/to/directory"); // replace with your directory path
        scanner.setFileExtension("txt"); // replace with your file extension
        scanner.scan();
    }
}

class FileScanner {
    private String directoryPath;
    private String fileExtension;

    public void setDirectory(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public void scan() {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files == null) {
            System.out.println("No files found!");
            return;
        }

        for (File file : files) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    System.out.println(scanner.nextLine());
                }
            }
        }
    }
}