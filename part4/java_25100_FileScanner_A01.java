import java.io.File;
import java.util.Scanner;

public class java_25100_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Reading files from directory: " + dir.getAbsolutePath());

            String[] files = dir.list();

            for (String file : files) {
                File currentFile = new File(dir, file);

                if (currentFile.isFile() && currentFile.canRead()) {
                    System.out.println("Reading file: " + currentFile.getAbsolutePath());

                    Scanner fileScanner = new Scanner(currentFile);

                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                   
                    }

                    fileScanner.close();
                }
            }
        } else {
            System.out.println("The provided path does not exist or is not a directory.");
        }

        scanner.close();
    }
}