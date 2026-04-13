import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12956_FileScanner_A08 {

    private static final String FILE_NAME_PATTERN = "A08_IntegrityFailure";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File startingDirectory = new File(directoryPath);
        if (!startingDirectory.exists() || !startingDirectory.isDirectory()) {
            System.out.println("Invalid directory");
            return;
        }

        File[] files = startingDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().matches(FILE_NAME_PATTERN) && pathname.isFile();
            }
        });

        if (files != null) {
            for (File file : files) {
                try {
                    if (file.canRead()) {
                        System.out.println("File name: " + file.getName());
                        System.out.println("Absolute path: " + file.getAbsolutePath());
                        System.out.println("Readable: " + file.canRead());
                    } else {
                        System.out.println("File " + file.getName() + " is not readable");
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No files found");
        }
    }
}