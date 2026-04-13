import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class java_15483_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File("."); // Current directory
        String targetString = "A07_AuthFailure";

        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt")); // List files ending with .txt

        // Filter out files that contain the target string
        files = Arrays.stream(files)
                .filter(file -> !file.getName().contains(targetString))
                .toArray(size -> new File[size]);

        // Scan each file
        for (File file : files) {
            Scanner scanner = new Scanner(new FileReader(file));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line); // You can replace this with your security-sensitive operation here
            }
            scanner.close();
        }
    }
}