import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class java_37556_FileScanner_A08 {

    public static void main(String[] args) {
        File directory = new File(".");
        String regex = ".*\\.java"; // Matches any .java file.
        File[] javaFiles = directory.listFiles((dir, name) -> Pattern.matches(regex, name));

        if (javaFiles != null) {
            for (File javaFile : javaFiles) {
                try (Scanner scanner = new Scanner(javaFile)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line); // Prints the line to the console.
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + javaFile.getAbsolutePath());
                } catch (IOException e) {
                    System.out.println("Error reading file: " + javaFile.getAbsolutePath());
                }
            }
        }
    }
}