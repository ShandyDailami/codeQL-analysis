import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class java_18018_XMLParser_A08 {
    public static void main(String[] args) {
        String filePath = "resources/sample.xml";  // replace with your file path
        parseXML(filePath);
    }

    private static void parseXML(String filePath) {
        XMLStreamReader reader = null;
        try {
            reader = new XMLStreamReader(new FileReader(filePath));
            int event = reader.getEventType();
            while (event != XMLStreamConstants.EOF) {
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.printf("Start element: %s%n", reader.getLocalName());
                        break;
                    case XMLStreamConstants.COMMENT:
                        System.out.println("Comment: " + reader.getComment());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.printf("End element: %s%n", reader.getLocalName());
                        break;
                    case XMLStreamConstants.ATTRIBUTE:
                        System.out.printf("Attribute: %s = %s%n", reader.getAttributeLocalName(), reader.getAttributeValue());
                        break;
                    default:
                        break;
                }
                event = reader.nextEvent();
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}