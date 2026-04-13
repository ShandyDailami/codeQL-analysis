import java.io.*; // For InputStream, OutputStream classes for file handling purposes
import org.xmlpull.v1.*; // Provides PullParser interface and XMLReader implementation class java_52947_XMLParser_A08 void parseXML(InputStream input) throws Exception {    
    try{      
        pullRequest request = new StreamRequest(input);        
          int event; 
           while ((event=request.getEvent()) != 0){             switch (event){              case HANDLER_START: // Start of document               default : break;}                }            }}                  catch (Exception e) {e.printStackTrace();}}   public class StreamRequest extends PullParser{      private InputStream stream;    
public boolean getEvent() throws Exception    {}       @Override           protected void setDocumentLocator(IDocLocator dl){}        static interface IDocLocator{}            }  // end of the namespace declaration. The name declared here is not used, it's only for identification purposes in this context}}