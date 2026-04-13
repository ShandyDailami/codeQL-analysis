import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20333_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the directory path:");
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
                                // Here is where you could implement your security-sensitive operation
                                // This is just a placeholder, you need to implement your own authentication logic here
                                if (line.contains("auth failure")) {
                                    System.out.println("Auth failure detected in file: " + file.getPath());
                                }
                            }
                            fileInput.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.println("No files found in the directory: " + directoryPath);
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }
    }
}