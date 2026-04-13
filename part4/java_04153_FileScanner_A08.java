import java.io.File;
import java.util.Scanner;

public class java_04153_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the directory:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try {
                            Scanner fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                // Here we just print the line for the sake of demonstration
                                System.out.println(line);
                           
                                // Simulating the integrity failure here
                                // We will try to read the next line and if it's not there, we will break the loop
                                if (!fileScanner.hasNextLine()) {
                                    break;
                                }
                            }
                            fileScanner.close();
                        } catch (Exception e) {
                            System.out.println("Error reading file: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("No files found in directory: " + directory.getPath());
            }
        } else {
            System.out.println("Directory does not exist or it's not a directory: " + directory.getPath());
        }
        scanner.close();
    }
}