import java.io.File;
import java.util.Scanner;

public class java_28695_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("textfile.txt");
        try (Scanner scanner = new Scanner(file)) {
            int sum = 0;
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
                for (String token : line.split("\\s+")) { // split line by spaces and tabs
                    try {
                        sum += Integer.parseInt(token);
                    } catch (NumberFormatException e) {
                        // skip if token is not a number
                    }
                }
            }
            System.out.println("Sum of all numbers: " + sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}