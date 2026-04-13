import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;

public class java_03536_XMLParser_A03 {
    public static void main(String[] args) {
        try (InputStream input = new FileInputStream("input.xml")) {
            XMLStreamReader reader = XMLStreamReader.newReader(input);
            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        String elementName = reader.getLocalName();
                        System.out.println("Start element: " + elementName);
                        break;
                    case XMLStreamConstants.CHARS:
                        String charContent = reader.getText();
                        System.out.println("Characters: " + charContent);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        elementName = reader.getLocalName();
                        System.out.println("End element: " + elementName);
                        break;
                    default:
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}