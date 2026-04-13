import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import java.io.StringReader;
import java.io.File;

public class java_39129_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlString = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";

        try {
            File xmlFile = new File("note.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));

            System.out.println("XML Parsed Successfully!");

            // Security-sensitive operations
            // Here, we are only parsing the XML and printing the details. 
            // In a real-world scenario, these operations could be a database query, an encryption/decryption, etc.
            System.out.println("To: " + doc.getElementsByTagName("to").item(0).getTextContent());
            System.out.println("From: " + doc.getElementsByTagName("from").item(0).getTextContent());
            System.out.println("Heading: " + doc.getElementsByTagName("heading").item(0).getTextContent());
            System.out.println("Body: " + doc.getElementsByTagName("body").item(0).getTextContent());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}