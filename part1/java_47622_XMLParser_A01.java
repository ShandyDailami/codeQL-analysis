import java.io.*;   // Import FileInputStream, InputStreamReader and BufferedReader classes   
     import javax.xml.parsers.*;//Import SAXParserFactory class java_47622_XMLParser_A01 create instance of the parser     
       public class XmlSAXParsing {       
         private static final String URL = "http://sample.com/books.xml";   //Sample XML file location         
           @SuppressWarnings("unused")     //To suppress warnings about unused variables (you can remove this once you have your SAXHandler ready)      
            public class MySAXHandler extends DefaultHandler {        protected void startDocument() {}        	protected void endDocument(){}  		    }      @SuppressWarnings("unused") 	public static void main(String[] args){          try{              XmlPullParserFactory factory = XmlPullParserFactory.newInstance();          
             FileInputStream fis  = new FileInputStream(URL);     //File Input Stream for XML file  	       BufferedReader reader=null;      Reader inputreader ; 	  String title   = "";        int line_number = 0;}         @Override public void startDocument() {title ="Book List";}         
             } catch (Exception e) {}    }}//Closing block of code for main method}}}}}