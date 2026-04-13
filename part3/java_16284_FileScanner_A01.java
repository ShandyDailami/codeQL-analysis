import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16284_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = input.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (file.getName().endsWith(".txt")) {
                            try (Scanner fileScanner = new Scanner(file)) {
                                while (fileScanner.hasNextLine()) {
                                    String line = fileScanner.nextLine();
                                    System.out.println(line);
                                }
                            } catch (FileNotFoundException e) {
                                System.out.println("File not found: " + file.getPath());
                            }
                        }
                    }
                }
            } else {
                System.out.println("No files in the directory.");
            }
        } else {
            System.out.println("Directory not found.");
        }

        input.close();
    }
}