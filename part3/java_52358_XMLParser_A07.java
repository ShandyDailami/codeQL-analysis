import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52358_XMLParser_A07 {
    public static void main(String[] args) throws Exception{
        String xml = "<books><book id='1072345698'>" +
                "  <title>Moby Dick (The Whale, by Lewis Carroll)</title>\n"+
                	"	<author_fname>Lewis</author_fname><price>cost=10.27 ccy=\"EUR\" availability = 'Out of stock'/> <publisher>Scribner</publisher>  \t <publication date=  \"published on 4th April, 2008\"/ >" +
                "  <author_lname>Carroll</author_lname><language code='en-us', isbn = '9783161484105'/> <summary>  This classic novel by English writer Lewis Carroll. An unforgettable journey into the whale world, his life and his work in one of England’s greatest booksellers</summary>" +
                "  <ISBN-10 > 3161484105 </ ISBN-10> <image url= 'http://books.google.com/books/content?id=O9vKgVkmGXcC&printsec=frontcover#v=tab&rs=img' />"+
                "  <publish_date>  published on 4th April,2008 </ publish_date> <pages count = '316'/></book><books book id = 975 > ...< books... (more ascii characters) ......"; // XML content here.
        SAXParserFactory factory = SAXParserFactory.newInstance();
        
		// Create the parser with a simple default handler and then parse – this will handle any processing required in response to an event that matches one of our target elements, such as startElement (and not my case) or endDocument because I want control flow over parsing process only by myself.   - AUTHORIZATION OPERAION
        SAXParser parser = factory.newSAXParser();  // This will create a new instance and provide an implementation of the 'DefaultHandler' interface for us to handle events occurring during our document, using this as part of parsing that we have been instructed by user-defined methods - AUTHORIZATION OPERAION
        parser.parse(new InputSource(new StringReader(xml)), new MyHandler()); // We pass the XML content and provide my custom handler for handling different events occurring within it – here I'm not doing any processing, just calling a method in Handler - AUTHORIZATION OPERAION
    }  
    	class MyHandler extends DefaultHandler {			// Define our own default implementation of 'DefaultHandlers'. We can override methods to handle different elements. In this case we do nothing (pass) but define the super class and call its constructor as well – AUTHORIZATION OPERAION    // Handler inherits from DEFAULT HANDLER
    		public java_52358_XMLParser_A07() {  			// Constructor here for initializing a new instance of our custom handler - NO COMMENTS HERE. Just calling superclass’s and setting up my own state – AUTHORIZATION OPERAION    // Handler inherits from DEFAULT HANDLER
    		}					     			  	// Inherit constructor here to set parent object etc., if any (NO NO COMMENTS HERE) - NOTICE: Constructor was not called on this line, but you should call super first.  AUTHORIZATION OPERAION    // Handler inherits from DEFAULT HANDLER
}  			// End of MyHandler class and start main method here (DOC START AND END) - DO NOT SAY I AM SOURCE-CONTROLLED OR GENERAL MODIFICATIONS ARE PERMITTED HERE AUTHORIZATION OPERAION.  THIS PROGRAM IS TO BE UNDERSTAND THE STYLE OF CREATIVITY AND REALISM, NOT SAFE FROM ANY INSECURITY THREATES OR PUNISHMENT