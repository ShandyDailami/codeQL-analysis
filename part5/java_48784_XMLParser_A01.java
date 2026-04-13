import javax.xml.parsers.*;
//... import statements ...  // This depends on your needs, but usually it'll include SAXParser or DOM parser if you want something lighter weight than JAXP

public class java_48784_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException{
        String xmlFile = "/path/to/your.xml";  // replace with your actual XML file path, this will be in byte format too; a real example would include the content of an external .XML File or resource like URLs etc...  
        
       try {   
           ParserFactory parserFactory=ParserFactory.newInstance();    
	          DocumentBuilderFactory dbfac =parserFactory.getDocumentBuilderFactory();  // Get XML Builder Factory     
             SchemaFactory sfac  =SchemaFactory.newInstance(dbfac);  
             
            /* Create an instance of the document builder */          
		    DocumentBuilder dbbuilder=sfac.newDocumentBuilder();    
	          System.out.println("Initializing parser........");      // Initialize JAXP to parse XML file  .....//this part might need a real example or mock-ups  
            /* Read the input xml and store in DOM object */   
		       Document doc= dbbuilder.parse(new File(xmlFile));     System.out.println("Document Built........");      // This will build our document tree  ...//this part might need a real example or mock-ups  
	           /* Initialize an error handler for the parsing */    ErrorHandler errh=null;        Document d = doc ;       if (d instanceof org.w3c.dom.Document){            // this is to overcome problems with XML version issues  ...//this part might need a real example or mock-ups
                System .out.println("XML Version : " + ((org.w3c.dom.Document) d).getXmlVersion());        errh = new org.xml.sax.error.ErrorHandler(){    public void fatalError ( java.lang.Exception e ) {  /* Handle the error */ }  
                // handle other errors here, for instance...       ErrorHandler em=null;      if(em== null){         System .out.println("Warning: "+e);     errh = new org.xml.sax.error.ErrorHandler(){    public void fatalError ( java.lang.Exception e ) {  /* Handle the error */ }      
                // handle other errors here, for instance...      };   System .out.println("Parsing......");     errh = new org.xml.sax.error.ErrorHandler(){    public void fatalError ( java.lang.Exception e ) {  /* Handle the error */ }      
                // handle other errors here, for instance...      };   System .out.println("Done...........");        if(errh != null){     dbfac = parserFactory;dbfac.setErrorHandler ( errh );}else{    DocumentBuilder dbbuilder1=  parserFactory 
                // Get XML Builder Factory       } ; else {System. out . println ("The document is not a valid one");}} catch(Exception e){ /* Handle the exception */ System .outprintln("Caught Exception : " +e);     if (d instanceof org.w3c.dom.Document)     
                // this to handle xml version issues, for instance... }    };   try{System  out-print ("Parsing......");}catch(Exception e){/* Handle the exception */ System .outprintln("Caught Exception : " +e);};     if (d instanceof org.w3c.dom.Document) { // this to handle xml version issues, for instance... } else