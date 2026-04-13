import java.util.XML;
import java.io.File;
import java.io.FileInputStream;

public class java_37516_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create an XMLStreamReader to read the XML document
            FileInputStream fis = new FileInputStream("resources/sample.xml");
            XML.StreamReader reader = XML.newStreamReader(fis, "UTF-8");
            
            // Parse the XML document
            int event;
            while ((event = reader.next()) != reader.END_DOCUMENT) {
                switch (event) {
                    case reader.START_ELEMENT: // An element has started
                        String elementName = reader.getElementLocalName();
                        System.out.print("Start of element " + elementName);
                        break;
                    case reader.CHARACTERS: // A characters event
                        String elementContent = reader.getElementCharacter();
                        System.out.print(elementContent);
                        break;
                    case reader.END_ELEMENT: // An element has ended
                        System.out.println(" End of element " + reader.getElementLocalName());
                        break;
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}