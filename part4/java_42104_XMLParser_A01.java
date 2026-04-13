import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamTokenizer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class java_42104_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            XMLStreamReader reader = getXMLStreamReader("src/test.xml");
            int event;
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
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static XMLStreamReader getXMLStreamReader(String fileName) throws FileNotFoundException {
        return new XMLStreamReader(new FileInputStream(fileName));
    }
}