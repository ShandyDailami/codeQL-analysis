import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class java_39860_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            Source xmlFile = new StreamSource(new File("src/main/resources/sample.xml"));
            XMLStreamReader reader = xmlFile.getReader();

            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        String elementName = reader.getLocalName();
                        System.out.println("Start element: " + elementName);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        elementName = reader.getLocalName();
                        System.out.println("End element: " + elementName);
                        break;
                }
            }
            reader.close();

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}