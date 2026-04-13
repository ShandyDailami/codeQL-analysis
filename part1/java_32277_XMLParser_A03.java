import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_32277_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load the XML document
            InputStream inputStream = new FileInputStream("sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputStream);

            // Security-sensitive operation: Print the document title
            System.out.println(doc.getDocumentElement().getTagName());

            // Security-sensitive operation: Print the first name of the document
            System.out.println(doc.getElementsByTagName("name").item(0).getTextContent());

            // Close the input stream
            inputStream.close();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}