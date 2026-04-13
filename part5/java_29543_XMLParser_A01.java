import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_29543_XMLParser_A01 {

    public void parse(String filePath) {
        File xmlFile = new File(filePath);
        try (Stream<String> stream = Files.lines(Paths.get(xmlFile.toPath()))) {
            stream.forEach(this::parseLine);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private void parseLine(String line) {
        // Remove the XML header and tail.
        line = line.replaceAll("<\\?xml[^>]*>", "").replaceAll("\\s*\\/\\s*$", "");
        // Parse the line into a namespace.
        String[] parts = line.split("\\s+");
        if (parts.length > 1) {
            String ns = parts[1];
            // Parse the rest into tags.
            String tag = parts[0].substring(parts[0].lastIndexOf('/') + 1);
            System.out.println("Parsed XML line: " + line);
            System.out.println("Namespace: " + ns);
            System.out.println("Tag: " + tag);
        }
    }
}