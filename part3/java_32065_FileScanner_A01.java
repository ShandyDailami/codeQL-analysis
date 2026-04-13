import java.io.*;

public class java_32065_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("/path/to/your/file");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("sensitive information")) {
                    System.out.println("Security alert: Sensitive information found!");
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}