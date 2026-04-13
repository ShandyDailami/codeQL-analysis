import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_18696_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");

            // Setting up DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Extract the data from the XML
            extractData(doc);

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void extractData(Document doc) {
        // Use the XML data here, for example:
        System.out.println("Title: " + doc.getElementsByTagName("title").item(0).getTextContent());
        System.out.println("Author: " + doc.getElementsByTagName("author").item(0).getTextContent());
    }
}