import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLReader;
import javax.xml.stream.XMLStreamConstants;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.InputStream;

public class java_25982_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml"; // replace with your xml file
        parseXML(xmlFile);
    }

    private static void parseXML(String xmlFile) {
        XMLStreamReader reader = null;
        try {
            InputStream input = new FileInputStream(xmlFile);
            reader = XMLStreamReader.newReader(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        String elementName = null;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = reader.getLocalName();
                    System.out.println("Start element: " + elementName);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String elementContent = reader.getText();
                    System.out.println("Element content: " + elementContent);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = reader.getLocalName();
                    System.out.println("End element: " + elementName);
                    break;
            }
        }
        try {
            reader.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}