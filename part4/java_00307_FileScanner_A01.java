import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00307_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = input.nextLine();

        File dir = new File(dirPath);

        if (dir.isDirectory()) {
            System.out.println("Scanning files in directory " + dir.getAbsolutePath());

            try {
                File[] files = dir.listFiles((dir2, name) -> name.endsWith(".txt"));
                if (files != null) {
                    for (File file : files) {
                        System.out.println("File found: " + file.getAbsolutePath());
                        // Here you can add the code to handle the file here.
                        // For example, reading the file content
                        Scanner fileInput = new Scanner(file);
                        while (fileInput.hasNextLine()) {
                            String line = fileInput.nextLine();
                            System.out.println(line);
                        }
                        fileInput.close();
                    }
                } else {
                    System.out.println("No .txt files found in directory " + dir.getAbsolutePath());
                }
            } catch (Exception e) {
                System.out.println("Error occurred while scanning directory: " + e.getMessage());
            }
        } else {
            System.out.println(dirPath + " is not a directory");
        }

        input.close();
    }
}