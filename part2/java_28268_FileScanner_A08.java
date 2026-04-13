import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class java_28268_FileScanner_A08 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(?<=^|\\s)([A-Z0-9]{4}_[A-Z0-9]{8})\\s(.*)");
        File file = new File("data.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (pattern.matcher(line).matches()) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}