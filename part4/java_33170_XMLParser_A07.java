import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class java_33170_XMLParser_A07 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("input.xml")) {
            XMLStreamReader reader = XMLStreamReader.newReader(fis);

            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        String elementName = reader.getLocalName();
                        if ("authFailure".equals(elementName)) {
                            int type = reader.getNamespaceURI().equals("A07_AuthFailure") ? XMLStreamConstants.START_ELEMENT : XMLStreamConstants.ELEMENT;
                            handleAuthFailure(reader, type);
                        }
                        break;
                    default:
                        break;
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static void handleAuthFailure(XMLStreamReader reader, int type) {
        // Handle authFailure element
    }
}