import java.io.*;
import java.util.*;

public class java_09522_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/sample.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            while (lineScanner.hasNext()) {
                String word = lineScanner.next();
                if (word.equals("error") || word.equals("failure")) {
                    System.out.println("Line " + (scanner.linNumber()) + ": " + line);
                }
            }
            lineScanner.close();
        }
        scanner.close();
    }
}