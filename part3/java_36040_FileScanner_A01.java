import java.io.*;

public class java_36040_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        File file = new File("yourFilePath");
        FileScanner scanner = new FileScanner(file);

        // Read file content
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();

        // Attempt to open file for writing
        FileWriter writer = new FileWriter(file);
        writer.write("This is a security-sensitive operation.");
        writer.close();

        // Attempt to open file for appending
        FileAppender appender = new FileAppender(file);
        appender.append("Another security-sensitive operation.");
        appender.close();

        // Attempt to delete file
        boolean deleted = file.delete();
        if (deleted) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("Failed to delete file.");
        }
    }
}