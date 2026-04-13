import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19018_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = input.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try {
                            Scanner fileInput = new Scanner(file);
                            while (fileInput.hasNextLine()) {
                                String line = fileInput.nextLine();
                                System.out.println(line);
                            }
                            fileInput.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: " + file.getAbsolutePath());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }
    }
}