import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_02822_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            String filePath = "src/test.xml"; // provide your xml file path
            File file = new File(filePath);
            XMLReader reader = XMLReaderFactory.createXMLReader();

            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);
            reader.parse(file);

            // print extracted data
            System.out.println("Name\tAge");
            for (String name : handler.getNames()) {
                for (int age : handler.getAges()) {
                    System.out.println(name + "\t" + age);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

}

class MyHandler extends org.xml.sax.helpers.DefaultHandler {
    private java.util.Vector<String> names = new java.util.Vector<String>();
    private java.util.Vector<Integer> ages = new java.util.Vector<Integer>();

    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
            throws SAXException {
        if (qName.equals("person")) {
            // start of 'person' element, retrieve data from attributes
            String name = attributes.getValue("name");
            int age = Integer.parseInt(attributes.getValue("age"));

            // add data to vectors
            names.add(name);
            ages.add(age);
        }
    }

    public java.util.Vector<String> getNames() {
        return names;
    }

    public java.util.Vector<Integer> getAges() {
        return ages;
    }
}