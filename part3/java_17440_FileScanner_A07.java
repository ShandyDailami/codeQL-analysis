import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17440_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");
        scanDirectory(directory, "A07_AuthFailure.txt");
    }

    private static void scanDirectory(File directory, String fileName) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().equals(fileName)) {
                        try {
                            Scanner scanner = new Scanner(file);
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                System.out.println("Line in file: " + line);
                            }
                            scanner.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    } else {
                        scanDirectory(file, fileName);
                    }
                }
            }
        }
    }
}