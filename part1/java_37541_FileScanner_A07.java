import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_37541_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner fileScanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = fileScanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            File[] listOfFiles = directory.listFiles();
            for (File file : listOfFiles) {
                if (file.isFile() && file.canRead()) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if (line.contains("auth failure")) {
                                System.out.println("Authentication failure detected in file: " + file.getPath());
                            }
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }

        fileScanner.close();
    }
}