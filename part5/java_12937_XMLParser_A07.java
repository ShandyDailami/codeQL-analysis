import org.xmlpull.v1.PullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;

public class java_12937_XMLParser_A07 {
    public static void main(String[] args) {
        String xml = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            PullParser parser = factory.newPullParser();
            parser.setInput(new StringReader(xml));

            parser.setXmlListener(new MyXMLListener());

            int event = parser.getEventType();
            while (event != PullParser.END_DOCUMENT) {
                String name = parser.getName();
                switch (event) {
                    case PullParser.START_TAG:
                        System.out.println("Start tag: " + name);
                        break;
                    case PullParser.END_TAG:
                        System.out.println("End tag: " + name);
                        break;
                    case PullParser.TEXT:
                        System.out.print("Text: " + parser.getText());
                        break;
                }
                event = parser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }

    static class MyXMLListener implements PullParser.EventListener2 {

        @Override
        public void onStartDocument() {
            System.out.println("Start of document");
        }

        @Override
        public void onEndDocument() {
            System.out.println("End of document");
        }

        @Override
        public void onStartPrefixMapping(String prefix, String uri) {
            System.out.println("Prefix mapping: " + prefix + " -> " + uri);
        }

        @Override
        public void onEndPrefixMapping(String prefix) {
            System.out.println("End of prefix mapping: " + prefix);
        }

        @Override
        public void onComment(String data) {
            System.out.println("Comment: " + data);
        }

        @Override
        public void onProcessingInstruction(String target, String data) {
            System.out.println("PI: " + target + " -> " + data);
        }

        @Override
        public void onStartElement(String namespaceURI, String localName, String qualifiedName, PullParser.Attributes attributes) {
            System.out.println("Start element: " + qualifiedName);
        }

        @Override
        public void onEndElement(String namespaceURI, String localName, String qualifiedName) {
            System.out.println("End element: " + qualifiedName);
        }

        @Override
        public void onText(CharSequence text) {
            System.out.println("Text: " + text);
        }
    }
}