import java.io.File;
import java.util.Scanner;

public class java_27207_FileScanner_A08 {
    private final String directoryPath;
    private final String extension;

    public java_27207_FileScanner_A08(String directoryPath, String extension) {
        this.directoryPath = directoryPath;
        this.extension = extension;
    }

    public void scan() {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("Found file: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("Error while scanning directory: " + directoryPath);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String extension = scanner.nextLine();

        FileScanner fileScanner = new FileScanner(directoryPath, extension);
        fileScanner.scan();
    }
}