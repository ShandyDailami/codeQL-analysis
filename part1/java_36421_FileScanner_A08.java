import java.io.File;
import java.util.Scanner;

public class java_36421_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        File dir = new File(path);

        if (dir.isDirectory()) {
            String[] fileList = dir.list();
            for (String fileName : fileList) {
                File file = new File(dir.getPath() + "/" + fileName);
                if (file.isFile()) {
                    if (fileName.endsWith(".txt")) {
                        try {
                            Scanner fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                System.out.println(line);
                           .
                            .
                            .
                            // Security sensitive operations related to integrity failure
                            }
                            fileScanner.close();
                        } catch (Exception e) {
                            System.out.println("An error occurred while reading the file: " + e.getMessage());
                        }
                    }
                }
            }
        } else {
            System.out.println("The provided path is not a directory.");
        }
    }
}