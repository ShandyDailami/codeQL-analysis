import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXSource;
import org.xml.sax.XMLReader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_09153_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory spf = SAXParserFactory.newInstance();

        try {
            SAXParser sp = spf.newSAXParser();
            MyHandler mh = new MyHandler();
            XMLReader xr = sp.getXMLReader();
            xr.setContentHandler(mh);

            SAXSource ss = new SAXSource(xr, new File("sample.xml"));
            sp.parse(ss, true);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {

    private StringBuilder sb;
    private boolean isElement;

    public java_09153_XMLParser_A01() {
        this.sb = new StringBuilder();
        this.isElement = false;
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {

        this.isElement = true;
        this.sb.setLength(0);
        this.sb.append("Start of ");
        this.sb.append(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        this.isElement = false;
        this.sb.append(" End of ");
        this.sb.append(qName);

        System.out.println(this.sb.toString());
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if (this.isElement) {
            this.sb.append(new String(ch, start, length));
        }
    }
}