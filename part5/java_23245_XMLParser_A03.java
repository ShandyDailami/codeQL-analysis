import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.StringReader;

public class java_23245_XMLParser_A03 {
    public static void main(String[] args) {
        String xml = "<note>\n" +
                "  <to>Tove</to>\n" +
                "  <from>Jani</from>\n" +
                "  <heading>Reminder</heading>\n" +
                "  <body>Don't forget me this weekend!</body>\n" +
                "</note>";

        // Parse the XML string into a Document object
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xml)));

        // Extract and print the data
        System.out.println("To: " + doc.getElementsByTagName("to").item(0).getTextContent());
        System.out.println("From: " + doc.getElementsByTagName("from").item(0).getTextContent());
        System.out.println("Heading: " + doc.getElementsByTagName("heading").item(0).getTextContent());
        System.out.println("Body: " + doc.getElementsByTagName("body").item(0).getTextContent());
    }
}