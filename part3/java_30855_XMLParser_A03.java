import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.StringReader;
import java.io.IOException;

public class java_30855_XMLParser_A03 {
    public static void main(String[] args) {
        String xml = "<note>\n" +
                "  <to>Tove</to>\n" +
                "  <from>Jani</from>\n" +
                "  <heading>Reminder</heading>\n" +
                "  <body>Don't forget me this weekend!</body>\n" +
                "</note>";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new StringReader(xml));

            String elementName = "";
            while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {
                switch (parser.getEventType()) {
                    case XmlPullParser.START_TAG:
                        elementName = parser.getName();
                        System.out.print("Start tag : " + elementName);
                        break;
                    case XmlPullParser.END_TAG:
                        System.out.print("End tag : " + parser.getName());
                        elementName = "";
                        break;
                    case XmlPullParser.TEXT:
                        if (elementName != null) {
                            System.out.print(" : " + parser.getText());
                        }
                        break;
                }
                parser.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}