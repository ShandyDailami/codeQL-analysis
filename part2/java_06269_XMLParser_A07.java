import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamToken;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class java_06269_XMLParser_A07 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("src/main/resources/sample.xml")) {
            XMLStreamReader reader = XMLStreamReader.newReader(fis);
            parse(reader);
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static void parse(XMLStreamReader reader) throws XMLStreamException {
        reader.nextTag(); // Skip the first tag.

        while (reader.hasNext()) {
            switch (reader.getEventType()) {
                case XMLStreamConstants.START_DOCUMENT:
                    System.out.println("Start of document");
                    break;
                case XMLStreamConstants.START_ELEMENT:
                    System.out.println("Start of element: " + reader.getLocalName());
                    break;
                case XMLStreamConstants.CHARACTERS:
                    if (reader.getText().equals("authFailure")) {
                        System.out.println("Warning: Detected authFailure sensitive operation!");
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    System.out.println("End of element: " + reader.getLocalName());
                    break;
                case XMLStreamConstants.END_DOCUMENT:
                    System.out.println("End of document");
                    break;
                default:
                    break;
            }
            reader.next();
        }
    }
}