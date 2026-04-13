import java.io.*;

public class java_11168_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            // Create a FileScanner instance
            File file = new File("target.txt");
            FileReader reader = new FileReader(file);
            Scanner scanner = new Scanner(reader);

            // Read the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Replace the injection string with a different one
                if (line.contains("injection")) {
                    line = line.replace("injection", "suspicious activity");
                }

                System.out.println(line);
            }

            // Close the scanner
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}