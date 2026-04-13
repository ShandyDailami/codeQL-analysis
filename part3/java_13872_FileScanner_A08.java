import java.io.File;
import java.util.Scanner;
import java.util.stream.Stream;

public class java_13872_FileScanner_A08 {

    public static void main(String[] args) {
        File file = new File("path_to_file"); // replace with your file path
        try (Stream<String> lines = new Scanner(file).tokens()) {
            lines.forEach(line -> {
                // Here is where you would perform the integrity check. 
                // In this example, we'll just print out the line to the console.
                System.out.println(line);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}