import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_18393_XMLParser_A01 {
    public static void main(String[] args) {
        XMLParser parser = null;
        DefaultHandler handler = null;

        try {
            // Create an instance of the XML parser
            parser = XMLParser.newInstance();

            // Create a SAX parser
            handler = new DefaultHandler();
            parser.setContentHandler(handler);

            // Load the XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("sample.xml"); // your xml file

            // Process the XML document
            parser.parse(new InputSource(new StringReader(document.toString())));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}