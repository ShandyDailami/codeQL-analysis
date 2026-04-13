import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_07798_XMLParser_A08 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        XMLReader reader;
        DefaultHandler handler = new DefaultHandler();

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(inputFile);

            // Print nodes names
            for (int i = 0; i < handler.getSize(); i++) {
                System.out.println(((DefaultHandler.NodeInfo)handler.getNodeInfo(i)).getNodeName());
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}