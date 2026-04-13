import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;

public class java_32229_XMLParser_A07 {

    public static void parse(XMLStreamReader reader) throws XMLStreamException {
        String name = null;
        String value = null;

        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    System.out.println("Start element: " + name);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    value = reader.getText();
                    System.out.println("Character data: " + value);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    System.out.println("End element: " + name);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            XMLStreamReader reader = XMLStreamReader.newReader(System.in);
            parse(reader);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}