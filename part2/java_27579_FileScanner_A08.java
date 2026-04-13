import java.io.*;

public class java_27579_FileScanner_A08 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java FileScanner <filename>");
            System.exit(1);
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("File not found!");
            System.exit(1);
        }

        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("IntegrityFailure")) {
                    count++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }

        System.out.println("Number of lines containing 'IntegrityFailure': " + count);
    }
}