import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class java_14198_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            XMLStreamReader reader = createXMLStreamReader();
            int event;
            while ((event = reader.next()) != XMLStreamReader.END_DOCUMENT) {
                switch (event) {
                    case XMLStreamReader.START_ELEMENT:
                        String elementName = reader.getLocalName();
                        System.out.println("Start element: " + elementName);
                        break;
                    case XMLStreamReader.CHARACTERS:
                        String elementContent = reader.getText();
                        System.out.println("Element content: " + elementContent);
                        break;
                    default:
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static XMLStreamReader createXMLStreamReader() throws FileNotFoundException {
        XMLStreamReader reader = new XMLStreamReader(new FileReader("src/main/resources/sample.xml"));
        return reader;
    }
}