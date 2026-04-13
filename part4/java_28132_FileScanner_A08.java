import java.io.File;
import java.util.Scanner;

public class java_28132_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File(".");
        String[] list = directory.list();
        for (String name : list) {
            File file = new File(name);
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains("error")) {
                        System.out.println("File: " + file.getName() + " contains the word 'error'");
                    }
                }
            } catch (Exception e) {
                System.out.println("Error occurred while processing file: " + file.getName());
            }
        }
    }
}