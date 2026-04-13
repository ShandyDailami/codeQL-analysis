import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class java_28691_XMLParser_A03 {
    public static void main(String[] args) {
        String fileName = "example.xml"; // replace with your file name
        parseXMLFile(fileName);
    }

    public static void parseXMLFile(String fileName) {
        try {
            File inputFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // Set the character encoding for the document
            doc.setCharacterEncoding(StandardCharsets.UTF_8.name());

            XMLReader reader = XMLReaderFactory.createXMLReader();
            DefaultHandler handler = new DefaultHandler();
            reader.setContentHandler(handler);

            // Parse the XML document
            reader.parse(new SAXSource(new InputSource(new StringReader(doc.getCharacterData().getData()))));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}