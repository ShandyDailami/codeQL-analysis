import java.io.File;
import java.util.Scanner;

public class java_22422_FileScanner_A03 {
    private static final String DIRECTORY_TO_SCAN = "C:\\"; // Change this to your directory
    private static final String FILE_EXTENSION = ".*\\.txt"; // Change this to your file extension

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your directory to scan:");
        String directory = scanner.nextLine();

        System.out.println("Enter your file extension:");
        String fileExtension = scanner.nextLine();

        File dir = new File(directory);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles((dir1, name) -> name.endsWith(fileExtension));

            if (files != null) {
                for (File file : files) {
                    if (file.exists() && file.canRead()) {
                        processFile(file);
                    }
                }
            } else {
                System.out.println("No files found in the directory!");
            }
        } else {
            System.out.println("Invalid directory!");
        }

        scanner.close();
    }

    private static void processFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Error processing file: " + file.getName());
        }
    }
}