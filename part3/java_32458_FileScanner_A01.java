import java.io.File;
import java.util.Scanner;

public class java_32458_FileScanner_A01 {
    private final File directory;
    private final String targetExtension;

    public java_32458_FileScanner_A01(String directoryPath, String targetExtension) {
        this.directory = new File(directoryPath);
        this.targetExtension = targetExtension;
    }

    public void scan() {
        File[] listOfFiles = directory.listFiles((dir, name) -> name.endsWith(targetExtension));
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.canRead()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // Sensitive operation here, example: logging potentially harmful content
                            System.out.println("Harmful content detected in: " + file.getPath());
                        }
                    }
                } else {
                    System.out.println("Access denied for: " + file.getPath());
                }
            }
        }
    }

    public static void main(String[] args) {
        BrokenAccessControlScanner scanner = new BrokenAccessControlScanner(".", ".txt");
        scanner.scan();
    }
}