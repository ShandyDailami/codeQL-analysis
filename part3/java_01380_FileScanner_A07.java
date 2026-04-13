import java.io.File;
import java.util.Scanner;

public class java_01380_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String dirPath = scanner.nextLine();
        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        if (fileName.endsWith(".txt")) {
                            try {
                                FileReader reader = new FileReader(file);
                                int r;
                                while ((r = reader.read()) != -1) {
                                    if (r >= 48 && r <= 57) {
                                        System.out.print((char) r);
                                    }
                                }
                                reader.close();
                            } catch (Exception e) {
                                System.out.println("Error while reading the file: " + fileName);
                            }
                        }
                    }
                }
            } else {
                System.out.println("No files in the directory: " + dirPath);
            }
        } else {
            System.out.println("Directory does not exist: " + dirPath);
        }

        scanner.close();
    }
}