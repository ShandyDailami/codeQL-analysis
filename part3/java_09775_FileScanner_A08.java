import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_09775_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String extension = ".txt";

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(extension));

            if (txtFiles != null) {
                Arrays.stream(txtFiles)
                        .filter(file -> file.isFile() && file.canRead())
                        .forEach(file -> {
                            try {
                                Scanner scanner = new Scanner(file);
                                while (scanner.hasNextLine()) {
                                    String line = scanner.nextLine();
                                    System.out.println(line);
                                }
                                scanner.close();
                            } catch (Exception e) {
                                System.out.println("An error occurred while reading the file: " + file.getName());
                            }
                        });
            } else {
                System.out.println("No files with extension: " + extension + " found in the directory: " + directoryPath);
            }
        } else {
            System.out.println("Directory: " + directoryPath + " does not exist or is not a directory");
        }
    }
}