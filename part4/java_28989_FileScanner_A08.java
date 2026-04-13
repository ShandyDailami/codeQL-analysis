import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28989_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/input.txt");

        try (Scanner scanner = new Scanner(file)) {
            int lines = 0;
            int words = 0;
            int characters = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines++;
                words += line.split("\\s+").length;
                characters += line.length();
            }

            System.out.println("Lines: " + lines);
            System.out.println("Words: " + words);
            System.out.println("Characters: " + characters);

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Error reading file!");
        }
    }
}