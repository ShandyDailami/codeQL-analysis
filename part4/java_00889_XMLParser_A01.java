import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.AccessControlException;
import java.security.AccessController;
import java.util.Objects;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamTokenizer;
import javax.xml.stream.XMLStreamReader.Event;

public class java_00889_XMLParser_A01 {

    private XMLStreamReader reader;

    public java_00889_XMLParser_A01(File file) {
        try {
            InputStream inputStream = new FileInputStream(file);
            reader = XMLStreamReader.newInstance(inputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void parse() {
        XMLStreamTokenizer tokenizer = reader.getTokenizer();
        Event nextEvent;

        try {
            while ((nextEvent = reader.next()) != Event.START_DOCUMENT) {
            }

            while (tokenizer.getEventType() != Event.END_DOCUMENT) {
                if (tokenizer.getEventType() == XMLStreamReader.START_ELEMENT) {
                    System.out.println("Start element: " + tokenizer.getName());
                } else if (tokenizer.getEventType() == XMLStreamReader.END_ELEMENT) {
                    System.out.println("End element: " + tokenizer.getName());
                }
                tokenizer.next();
            }
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        if (!xmlFile.exists()) {
            System.out.println("XML file not found!");
            return;
        }

        BrokenAccessControlXMLParser parser = new BrokenAccessControlXMLParser(xmlFile);
        parser.parse();
    }
}