import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class java_20564_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("test.txt");
        Scanner scanner = null;
        FileWriter writer = null;

        try {
            if (file.exists()) {
                scanner = new Scanner(file);
                writer = new FileWriter("test_out.txt");

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    writer.write(line + System.lineSeparator());
                }
            } else {
                System.out.println("File does not exist.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("An error occurred while closing the writer.");
                }
            }
        }
    }
}