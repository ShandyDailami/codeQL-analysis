import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_13983_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            parseFile("example.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static void parseFile(String fileName) throws FileNotFoundException, SAXException {
        FileInputStream fis = new FileInputStream(new File(fileName));
        XMLReader reader = XMLReaderFactory.createXMLReader();
        DefaultHandler handler = new DefaultHandler();
        reader.setContentHandler(handler);
        reader.parse(fis);

        printNode(handler.getCurrentNode());

        fis.close();
    }

    private static void printNode(org.xml.sax.helpers.DefaultNode node) {
        if (node == null) {
            return;
        }

        if (node.getNodeType() == org.xml.sax.helpers.DefaultNode.ELEMENT_NODE) {
            System.out.println(node.getNodeName() + " : " + node.getNodeValue());
        }

        Iterator iter = node.getChildNodes();
        while (iter.hasNext()) {
            printNode((org.xml.sax.helpers.DefaultNode) iter.next());
        }
    }
}