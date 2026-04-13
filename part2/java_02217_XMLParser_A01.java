import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamToken;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class java_02217_XMLParser_A01 {

    public static void main(String[] args) {
        try (XMLStreamReader reader = createXMLStreamReader()) {
            while (reader.hasNext()) {
                XMLStreamToken token = reader.next();
                switch (token.getTokenType()) {
                    case START_ELEMENT:
                        System.out.println("Start of element: " + reader.getLocalName());
                        break;
                    case END_ELEMENT:
                        System.out.println("End of element: " + reader.getLocalName());
                        break;
                    case CHARACTERS:
                        System.out.println("Character data: " + reader.getText());
                        break;
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static XMLStreamReader createXMLStreamReader() throws FileNotFoundException {
        return new XMLStreamReader(new FileInputStream("input.xml"));
    }
}