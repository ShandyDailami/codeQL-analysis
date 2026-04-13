import java.net.URL;
import org.xmlpull.v1.XMLPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class java_18370_XMLParser_A08 {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://example.com/example.xml");
            XMLPullParserFactory factory = XMLPullParserFactory.newInstance();
            XMLPullParser xpp = factory.newPullParser();
            xpp.setInput(url.openStream(), null);

            int event = xpp.getEventType();

            while (event != XMLPullParser.END_DOCUMENT) {
                String name = xpp.getName();

                switch (event) {
                    case XMLPullParser.START_DOCUMENT:
                        System.out.println("Start of document");
                        break;
                    case XMLPullParser.START_TAG:
                        System.out.print("Start tag : " + name);
                        break;
                    case XMLPullParser.END_TAG:
                        System.out.println("End tag : " + name);
                        break;
                    case XMLPullParser.CHARS:
                        System.out.print("Chars: " + xpp.getText());
                        break;
                    case XMLPullParser.COMMENT:
                        System.out.println("Comment: " + xpp.getComment().toString());
                        break;
                    case XMLPullParser.SPACE:
                        System.out.print("Space: " + xpp.getEventType());
                        break;
                    case XMLPullParser.CDATA:
                        System.out.println("CDATA section");
                        break;
                    default:
                        break;
                }
                event = xpp.next();
            }
            xpp.close();

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }
}