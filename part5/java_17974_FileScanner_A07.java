import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_17974_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File file = new File(directoryPath);

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();

                if (files != null) {
                    for (File f : files) {
                        if (f.isFile()) {
                            String fileName = f.getName();
                            if (fileName.endsWith(".txt")) {
                                try {
                                    Scanner fileScanner = new Scanner(f);
                                    while (fileScanner.hasNextLine()) {
                                        String line = fileScanner.nextLine();
                                        
                                        // Insert your security-sensitive operation here
                                        
                                    }
                                    fileScanner.close();
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            } else {
                System.out.println("The path is not a directory.");
            }
        } else {
            System.out.println("The directory does not exist.");
        }

        scanner.close();
    }
}