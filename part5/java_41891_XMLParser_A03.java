import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_41891_XMLParser_A03 {

    public static void main(String[] args) {
        // Step 1: Create a DocumentBuilderFactory and use it to get a DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Step 2: Parse the XML file
        Document document;
        try {
            document = builder.parse(new File("sample.xml")); // replace with your file
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            return;
        }

        // Step 3: Create a SAXHandler to handle the XML document
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, javax.xml.dom.Attributes attributes) {
                // Handle start elements here, for example:
                // System.out.println("Start element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) {
                // Handle end elements here, for example:
                // System.out.println("End element: " + qName);
            }
        };

        // Step 4: Create a XMLReader from the DocumentBuilder and set it to handle the Document
        XMLReader reader = builder.newSAXReader(document);
        reader.setContentHandler(handler);

        // Step 5: Process the document
        try {
            reader.parse(new InputSource(new StringReader(document.getDocumentElement().getFirstChild().getNodeValue())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}