import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_33606_XMLParser_A01 {

    private DocumentBuilderFactory factory;

    public java_33606_XMLParser_A01() {
        factory = DocumentBuilderFactory.newInstance();
    }

    public Optional<Document> parse(String fileName) {
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream(fileName));
            return Optional.of(document);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return Optional.empty();
        } catch (ParserConfigurationException e) {
            System.out.println("Failed to parse configuration: " + e.getMessage());
            return Optional.empty();
        } catch (SAXException e) {
            System.out.println("Failed to parse XML: " + e.getMessage());
            return Optional.empty();
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parse("sample.xml").ifPresent(doc -> System.out.println("Parsed successfully"));
    }
}