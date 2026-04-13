import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;

public class java_12622_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "path_to_your_file.xml";  // replace with your xml file path
        parseFile(xmlFile);
    }

    public static void parseFile(String xmlFile) {
        FileInputStream fis = null;
        XMLStreamReader reader = null;
        try {
            fis = new FileInputStream(new File(xmlFile));
            reader = XMLStreamReader.newReader(fis);
            System.out.println("Parsing XML file: " + xmlFile);
            int event = reader.getEventType();
            while (event != XMLStreamReader.END_DOCUMENT) {
                String name = reader.getName();
                switch (event) {
                    case XMLStreamReader.START_ELEMENT:
                        System.out.println("Start of element: " + name);
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        System.out.println("End of element: " + name);
                        break;
                    case XMLStreamReader.CHARACTERS:
                        System.out.println("Characters: " + reader.getText());
                        break;
                }
                event = reader.nextEvent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        }
    }
}