import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class java_03974_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a new instance of XMLReader
            XMLReader reader = XMLReader.newInstance();

            // Create a new instance of AuthFailureHandler
            AuthFailureHandler handler = new AuthFailureHandler() {
                @Override
                public void handleAuthFailure(String detailMessage) {
                    System.out.println(detailMessage);
                }
            };

            // Set the AuthFailureHandler for the XMLReader
            reader.setContentHandler(new ContentHandler() {
                @Override
                public void startDocument() {}

                @Override
                public void endDocument() {}

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {}

                @Override
                public void endElement(String uri, String localName, String qName) {}

                @Override
                public void characters(char[] ch, int start, int length) {}

                @Override
                public void ignorableWhitespace(char[] ch, int start, int length) {}

                @Override
                public void processingInstruction(String target, String data) {}

                @Override
                public void setDocumentLocator(Locator locator) {}

                @Override
                public void startPrefixMapping(String prefix, String uri) {}

                @Override
                public void endPrefixMapping(String prefix) {}

                @Override
                public AuthFailureHandler getAuthFailureHandler() {
                    return handler;
                }
            });

            // Set the reader's entity handler
            reader.setEntityHandler(new EntityHandler() {
                @Override
                public void notationDecl(String name, String pubID, String sysID) {}

                @Override
                public InputSource resolveEntity(String pubID, String sysID) {
                    return null;
                }
            });

            // Parse the XML document
            reader.parse(new InputSource(new StringReader("<root></root>")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}