import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;

public class java_26125_XMLParser_A07 {

    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("path_to_your_file.xml")) {
            XMLStreamReader reader = XMLStreamReader.newReader(input);
            String element;
            while (reader.hasNext()) {
                element = reader.nextElement();
                if (element.equals(XMLStreamConstants.START_ELEMENT)) {
                    element = reader.getLocalName();
                    if (element.equals("AuthFailure")) {
                        System.out.println("Found sensitive data!");
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}