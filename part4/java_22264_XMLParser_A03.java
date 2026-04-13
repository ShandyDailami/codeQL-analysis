import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;

public class java_22264_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlData = "<note>\n" +
                "  <to>Tove</to>\n" +
                "  <from>Jani</from>\n" +
                "  <heading>Reminder</heading>\n" +
                "  <body>Don't forget me this weekend!</body>\n" +
                "</note>";

        XMLReader parser = null;

        try {
            parser = XMLReaderFactory.createXMLReader();

            parser.setContentHandler(new DefaultHandler(){

                @Override
                public void startDocument() throws SAXException {
                    System.out.println("Start of Document");
                }

                @Override
                public void endDocument() throws SAXException {
                    System.out.println("End of Document");
                }

                @Override
                public void startElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("Start of Element: "+qName);
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End of Element: "+qName);
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    String content = new String(ch, start, length);
                    System.out.println("Content: "+content);
                }
            });

            parser.parse(new StringReader(xmlData));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (parser != null) {
                parser.getReader().close();
            }
        }
    }
}