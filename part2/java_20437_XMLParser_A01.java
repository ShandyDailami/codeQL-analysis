import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_20437_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("example.xml");
            XMLReader xr = XMLReaderFactory.createXMLReader();

            MyHandler mh = new MyHandler();
            mh.startElement("", "root", "http://www.example.com/");

            xr.setContentHandler(mh);
            xr.parse(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements org.xml.sax.helpers.DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private boolean bSalary = false;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("Employee")) {
            bName = true;
            bAge = true;
            bSalary = true;
        }

        if (qName.equalsIgnoreCase("Name")) {
            bName = true;
        }

        if (qName.equalsIgnoreCase("Age")) {
            bAge = true;
        }

        if (qName.equalsIgnoreCase("Salary")) {
            bSalary = true;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Employee")) {
            bName = false;
            bAge = false;
            bSalary = false;
        }

        if (qName.equalsIgnoreCase("Name")) {
            bName = false;
        }

        if (qName.equalsIgnoreCase("Age")) {
            bAge = false;
        }

        if (qName.equalsIgnoreCase("Salary")) {
            bSalary = false;
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.print("Name: ");
            System.out.print(new String(ch, start, length));
            System.out.print(" ");
        }

        if (bAge) {
            System.out.print("Age: ");
            System.out.print(new String(ch, start, length));
            System.out.print(" ");
        }

        if (bSalary) {
            System.out.print("Salary: ");
            System.out.println(new String(ch, start, length));
        }

    }

}