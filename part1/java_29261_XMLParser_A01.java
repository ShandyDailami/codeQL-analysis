import java.security.*;
import javax.xml.stream.*;

public class java_29261_XMLParser_A01 {

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
        // Create a new XMLStreamReader for reading
        XMLStreamReader reader = createXmlStreamReader();

        // Read the XML document
        int event;
        while ((event = reader.getEventType()) != XMLStreamConstants.END_DOCUMENT) {
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    String elementName = reader.getLocalName();
                    System.out.println("Start element: " + elementName);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String charData = reader.getText();
                    System.out.println("Characters: " + charData);
                    break;
                default:
                    break;
            }
            reader.nextEvent();
        }

        // Close the reader
        reader.close();
    }

    private static XMLStreamReader createXmlStreamReader() throws NoSuchAlgorithmException, NoSuchProviderException {
        // Get the XML Streaming API provider
        Provider provider = Provider.find(" org.apache.xerces " +
                "org.w3c.dom.events " +
                "org.apache.xpath.dom.functions.DOMFunctions " +
                "org.apache.xml.dom.utils " +
                "org.apache.xerces.jaxp.impl.XercesSaxReader " +
                "org.xml.sax.helpers " +
                "org.w3c.dom " +
                "org.xml.sax " +
                "org.w3c.dom.events ");

        // Get the SecurityManager
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkUserAuthorization(provider.getClassName());
        }

        // Create an XMLStreamReader with the provider and a read-only mode
        XMLStreamReaderFactory factory = provider.getXMLStreamReaderFactory();
        XMLStreamReader reader = factory.createXMLStreamReader(
                provider.getXMLReader(),
                null,
                provider.getDOMConfiguration(),
                provider.getXMLStreamFeatures(),
                provider.getXMLReaderFeatures(),
                false
        );

        return reader;
    }
}