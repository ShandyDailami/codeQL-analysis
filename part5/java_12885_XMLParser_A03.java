import java.util.stream.Stream;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_12885_XMLParser_A03 {

    public static void parseXML(String xml) throws XMLStreamException {
        XMLStreamReader reader = XMLStreamConstants.parseXML(xml);

        while (reader.hasNext()) {
            int event = reader.next();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    String elementName = reader.getLocalName();
                    System.out.println("Start element: " + elementName);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String elementContent = reader.getText();
                    System.out.println("Content: " + elementContent);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = reader.getLocalName();
                    System.out.println("End element: " + elementName);
                    break;
            }
        }

        reader.close();
    }

    public static void main(String[] args) throws XMLStreamException {
        String xml = "<person><name>John</name><age>30</age></person>";
        parseXML(xml);
    }
}