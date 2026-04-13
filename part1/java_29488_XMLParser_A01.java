import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_29488_XMLParser_A01 {
    public static void main(String[] args) {
        String xml = "<note>" +
                "<to>Tove</to>" +
                "<from>Jani</from>" +
                "<message>Reminder: Schedule meeting.</message>" +
                "</note>";

        try (XMLStreamReader reader = XMLStreamFactory.createXMLStreamReader(xml)) {
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        String element = reader.getLocalName();
                        System.out.println("Start element: " + element);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String character = reader.getText();
                        System.out.println("Text: " + character);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        element = reader.getLocalName();
                        System.out.println("End element: " + element);
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}