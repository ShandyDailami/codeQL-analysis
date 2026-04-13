import java.io.*;  // Import FileInputSteam, PrintWriter and others    
public class java_43992_XMLParser_A08 {     
       public static void main(String[] args) throws Exception{         
              String xmlFile = "samplefile";            
               SAXParserFactory saxpFactory = SAXParserFactory.newInstance();           
	   try (SAXParser saxp = saxpFactory.newSAXParser()) {  // Use this factory to create a SAX parser         
                XMLReader xreader =  saxp.getXMLReader();       
              CustomHandler ch  = new CustomHandler(xmlFile);    
	       xreader.setContentHandler(ch );     
               BufferedInputStream bis = null;            
		   try {           // Use the buffering in a file           
                    File inputFile=new File( xmlFile + ".xml");   
                           if ( !inputFile.exists() ){              System.err .println("Input File "+    
                             xmlFile  +". not found" );             return;          }  bis = new BufferedInputStream   // Read in a buffer          
                  Reader in =  null ;         try {                 in  =new InputStreamReader(      fis,       charset);                   if ( !isValidCharset(charset) ){    System.err .println("Unsupported Charset while reading file" );            return; }  xreader  =  saxp    
                  .parse(in , ch)} catch (Exception e){           // ParsingFailed Exception         throw new          ParseException        ("Parse Error",e);             }}              finally {if(bis != null) bis.close();}}       unsupportedOperation  }})`      */    });