import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07258_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        FileScanner fs = new FileScanner();
        fs.start();
    }

    public void start() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Input is not a directory");
            return;
        }

        System.out.println("Enter the name pattern (e.g. .txt, .jpg): ");
        String pattern = scanner.nextLine();

        File[] files = directory.listFiles((dir, name) -> name.endsWith(pattern));

        if (files == null) {
            System.out.println("No files found with pattern: " + pattern);
            return;
        }

        System.out.println("Files with pattern " + pattern + ":");
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}