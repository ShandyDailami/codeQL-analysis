import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class java_34883_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Create an instance of the XMLReader interface
            XMLReader xr = XMLReaderFactory.createXMLReader();
            
            // Step 2: Create a new handler
            MyHandler handler = new MyHandler();
            
            // Step 3: Set the handler for the XMLReader
            xr.setContentHandler(handler);
            
            // Step 4: Parse the XML document
            xr.parse(new InputSource(new FileInputStream("example.xml")));
            
            // Step 5: Print the results
            for(int i = 0; i < handler.getCount(); i++) {
                System.out.println("Node " + (i + 1) + ": " + handler.getNode(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements ContentHandler {
    private String[] nodes = new String[100];
    private int count = 0;
    
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        nodes[count] = qName;
        count++;
    }
    
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Do nothing here, as we are only interested in the nodes
    }
    
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Do nothing here, as we are only interested in the nodes
    }
    
    public String[] getNodes() {
        return nodes;
    }
    
    public int getCount() {
        return count;
    }
    
    public String getNode(int index) {
        return nodes[index];
    }
}