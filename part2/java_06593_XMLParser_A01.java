import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamToken;

public class java_06593_XMLParser_A01 {

    public static void parse(XMLStreamReader reader) {
        int event;
        try {
            while (reader.hasNext()) {
                event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.println("Start element: " + reader.getLocalName());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.println("End element: " + reader.getLocalName());
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        System.out.print(reader.getText());
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XMLStreamReader reader = XMLStreamConstants.createXMLEventReader(new StringReader("<note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>"));
        parse(reader);
    }
}