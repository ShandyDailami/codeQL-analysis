import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLReader;
import javax.xml.stream.XMLStreamConstants;

public class java_35271_XMLParser_A03 {
    public static void main(String[] args) {
        String xml = "<person><name>John</name><age>30</age></person>";

        try {
            XMLStreamReader reader = XMLReaderFactory.createXMLStreamReader(xml.getBytes("UTF-8"));

            System.out.println("Start Element: " + reader.getLocalName());

            int event = reader.getEventType();
            while (event != XMLStreamConstants.END_DOCUMENT) {
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.println("Start Element: " + reader.getLocalName());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.println("End Element: " + reader.getLocalName());
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        System.out.println("Characters: " + reader.getText());
                        break;
                }
                event = reader.nextEvent();
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}