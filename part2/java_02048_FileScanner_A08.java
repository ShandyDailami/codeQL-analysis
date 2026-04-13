import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02048_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "path_to_directory";  // replace with your directory path
        String extension = ".txt";  // replace with your file extension

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

            if (files != null) {
                for (File file : files) {
                    if (file.canRead()) {
                        Scanner scanner = null;
                        try {
                            scanner = new Scanner(file);
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // Add integrity check logic here
                                // For now, let's say the integrity check fails if the line contains 'A08_IntegrityFailure'
                                if (line.contains("A08_IntegrityFailure")) {
                                    System.out.println("Integrity failure detected in file: " + file.getAbsolutePath());
                                }
                            }
                            scanner.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }
    }
}