import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamToken;

public class java_03630_XMLParser_A03 {

    public static void main(String[] args) {
        String xml = "<person><name>John</name><age>30</age><city>New York</city></person>";
        parseXML(xml);
    }

    private static void parseXML(String xml) {
        XMLStreamReader reader = null;
        try {
            reader = XMLStreamReader.newInstance(xml);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        int event;
        try {
            event = reader.getEventType();
            while (event != XMLStreamReader.EVENT_TYPE_END) {
                switch (event) {
                    case XMLStreamReader.START_ELEMENT:
                        System.out.println("Start element: " + reader.getLocalName());
                        break;
                    case XMLStreamReader.CHARACTERS:
                        System.out.print(reader.getText());
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        System.out.println("End element: " + reader.getLocalName());
                        break;
                    default:
                        break;
                }
                event = reader.nextEvent();
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}