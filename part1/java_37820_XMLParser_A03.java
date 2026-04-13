import java.io.File;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_37820_XMLParser_A03 extends DefaultHandler {

    private static final String ALLOWED_TAGS = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";

    public static void main(String[] args) {
        File xmlFile = new File("your_xml_file.xml");
        SAXReader reader = SAXReaderFactory.newInstance();

        try {
            XMLReader xmlReader = reader.getXMLReader();
            xmlReader.setContentHandler(new XMLParser());
            xmlReader.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        if (!isTagAllowed(qName)) {
            throw new SAXException("SAX Exception: The tag '" + qName + "' is not allowed!");
        }
    }

    private boolean isTagAllowed(String tag) {
        return (ALLOWED_TAGS.indexOf(tag) != -1);
    }
}