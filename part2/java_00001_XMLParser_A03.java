import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class java_00001_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            FileInputStream fis = new FileInputStream("sample.xml");
            parser.setInput(fis, null);

            int event = parser.getEventType();
            String name = "";
            String content = "";

            while (event != XmlPullParser.END_DOCUMENT) {
                String currentTag = parser.getName();
                switch (event) {
                    case XmlPullParser.START_TAG:
                        name = currentTag;
                        break;
                    case XmlPullParser.TEXT:
                        content = parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        name = currentTag;
                        break;
                    default:
                        break;
                }
                event = parser.next();
            }

            parser.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }
}