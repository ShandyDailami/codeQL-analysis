import java.io.File;
import java.util.Scanner;

public class java_16432_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        System.out.println("Reading file: " + file.getPath());

                        try (Scanner fileScanner = new Scanner(file)) {
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                System.out.println(line);
                           
                                // This line is just for demonstration of syntax, it won't actually cause an error
                                // if the file is not readable.
                                if (line.contains("BROKEN_ACCESS")) {
                                    System.out.println("Broken access detected in: " + file.getPath());
                                }
                            }
                            fileScanner.close();
                        } catch (Exception e) {
                            System.out.println("Error while reading file: " + file.getPath());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}