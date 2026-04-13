import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_23294_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory
        String extension = ".txt";

        File directory = new File(directoryPath);
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (txtFiles != null) {
            for (File file : txtFiles) {
                List<String> lines = new ArrayList<>();
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        lines.add(scanner.nextLine());
                    }
                }
                // print lines
                for (String line : lines) {
                    System.out.println(line);
                }
            }
        }
    }
}