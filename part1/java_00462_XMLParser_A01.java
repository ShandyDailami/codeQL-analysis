import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_00462_XMLParser_A01 {

    public static void main(String[] args) {
        // Step 1: Initialize the DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Step 2: Obtain a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file
            Document doc = builder.parse("input.xml");

            // Step 4: Process the document
            // Here we'll print out the XML document's content
            System.out.println(doc.toString());

        } catch (SAXException | IllegalArgumentException e) {
            e.printStackTrace();
       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}