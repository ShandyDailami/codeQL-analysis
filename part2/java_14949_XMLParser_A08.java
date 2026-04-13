import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestException;

import org.apache.xml.parsers.DocumentBuilder;
import org.apache.xml.parsers.DocumentBuilderFactory;
import org.apache.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_14949_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Create a new Document using one of the builder's methods
            Document doc = builder.parse(new FileInputStream("sample.xml"));

            // TODO: Add code to parse and handle XML document.
            // Here we just print the document's element names
            doc.getElementsByTagName("sampleTag").item(0).getTextContent();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}