import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class java_38641_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            XMLStreamReader reader = getXMLStreamReader("example.xml");
            int event;
            while ((event = reader.next()) != XMLStreamReader.END_DOCUMENT) {
                switch (event) {
                    case XMLStreamReader.START_ELEMENT:
                        String elementName = reader.getLocalName();
                        System.out.println("Start element: " + elementName);
                        break;
                    case XMLStreamReader.CHARACTERS:
                        String character = reader.getText();
                        System.out.println("Character data: " + character);
                        break;
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public static XMLStreamReader getXMLStreamReader(String fileName) throws FileNotFoundException, XMLStreamException {
        XMLStreamReader reader = null;
        reader = new XMLStreamReader(new FileInputStream(fileName));
        return reader;
    }
}