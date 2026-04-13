import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamTokenizer;
import javax.xml.stream.XMLStreamException;

public class java_07758_XMLParser_A03 {

    public static void main(String[] args) {
        File file = new File("yourfile.xml"); // replace "yourfile.xml" with your xml file
        try (Stream<String> stream = Files.lines(Paths.get(file.getPath()))) {
            stream.forEach(XmlParser::printLinesWithInjection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printLinesWithInjection(String line) {
        XMLStreamTokenizer tokenizer = new XMLStreamTokenizer();
        try {
            tokenizer.setInput(line);
            while (tokenizer.nextToken() != XMLStreamTokenizer.END_DOCUMENT) {
                switch (tokenizer.getTokenId()) {
                case XMLStreamTokenizer.START_DOCUMENT:
                    // Do nothing
                    break;
                case XMLStreamTokenizer.START_ELEMENT:
                    if (line.contains("injection")) {
                        System.out.println("Line: " + line);
                    }
                    break;
                default:
                    break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}