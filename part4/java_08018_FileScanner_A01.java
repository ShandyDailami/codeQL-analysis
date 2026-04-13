import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08018_FileScanner_A01 {

    public static void main(String[] args) {
        File directory = new File(".");

        if (directory.isDirectory()) {
            String[] list = directory.list();
            for (String fileName : list) {
                File file = new File(fileName);
                if (file.isFile() && file.canRead()) {
                    try (Scanner scanner = new Scanner(file)) {
                        System.out.println("File: " + fileName);
                        System.out.println("Length: " + file.length());

                        int lineNumber = 1;
                        while (scanner.hasNextLine()) {
                            System.out.println("Line " + lineNumber + ": " + scanner.nextLine());
                            lineNumber++;
                        }

                        System.out.println();
                    } catch (FileNotFoundException e) {
                        System.out.println("Unable to read file: " + fileName);
                    }
                }
            }
        } else {
            System.out.println("Not a directory");
        }
    }
}