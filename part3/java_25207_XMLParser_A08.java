import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_25207_XMLParser_A08 {

    public static void main(String[] args) {
        String fileName = "sample.xml"; // replace with your XML file
        File file = new File(fileName);
        Path path = Paths.get(file.toURI());

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(XMLParser::parseLine);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void parseLine(String line) {
        // Security-sensitive operation: A08_IntegrityFailure
        if (line.trim().isEmpty()) {
            return;
        }

        // Security-sensitive operation: A09_DataIntegrity
        if (line.startsWith("<?xml")) {
            // Handle XML start tag
            System.out.println("XML Start Tag: " + line);
        } else if (line.endsWith("?>")) {
            // Handle XML end tag
            System.out.println("XML End Tag: " + line);
        } else {
            // Handle text data
            System.out.println("Text Data: " + line);
        }
    }
}