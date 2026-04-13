import java.io.*;   // for InputStream, OutputStream etc.. 
import org.xmlpull.*;// XMLPullParser interface and classes (starting with XP)   
                    
public class java_46344_XMLParser_A07 {                                                  
     public static void main(String[] args){                                       
           try{                                                                      
             // create a new instance of the default xml pull parser                 
              XMLPullParserFactory xppf = XMLPullParserFactory.newInstance(); 
              
				// setup to parse an input stream                	  
                XPStAXSource staxSource =  new XPStAXSource(                                                     
                        new FileInputStream("sampleFile.xml"),                                        // the InputStream            	 	   	       	     		         				           XmlResources.class);             
                 
               XMLPullParser xpp =     xppf .newPullParser();               	                         			                  					   XPBaseExtended.class;       						   															       return  new Object(){@Override public void run() {}};}public int hashCode ()             @Deprecated, incompatible with super