import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31792_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            // Create a FileScanner object to read the file
            FileScanner scanner = new FileScanner();

            // Use the scanner to read a file
            scanner.scanFile("src/main/resources/example.txt", "A03_Injection");

            // Print the results
            System.out.println(scanner.getResults());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class FileScanner {
    private String results;

    public void scanFile(String filePath, String searchTerm) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        StringBuilder builder = new StringBuilder();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.contains(searchTerm)) {
                builder.append(line).append("\n");
            }
        }

        results = builder.toString();
    }

    public String getResults() {
        return results;
    }
}