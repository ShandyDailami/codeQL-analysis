import org.xml.sax.*;
import org.apache.commons.lang3.StringEscapeUtils;
public class java_44719_XMLParser_A01 implements SAXHandler {     // Step a, b and c are done here as per your instructions above   
                                                    private StringBuffer sf = new StringBuffer();  
  public void startElement(String uri, String localName, String qName) throws SAXException{      }        @Override       protected boolean isSafeResourceUrl (final URI url){         // Step e and f are done here as per your instructions above     if ("http://security-sensitive.com".equalsIgnoreCase(url)) { return false;  }}