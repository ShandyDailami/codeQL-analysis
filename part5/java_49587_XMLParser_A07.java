import java.io.*; // for InputStream, OutputStream and FileReader/Writer classes  

import javax.xml.parsers.*;//for XMLParser interface class java_49587_XMLParser_A07 org.w3c.dom.*; //DOM (Document) API   

import org.xml.sax.*;  //SAX(Simple API for XML ) is an application programming interfaces available in Java SE that provide a simple way to parse and validate the Document Object Model of any kind with ease    

//for Parsing Exception handling  

public class Main {   

 public static void main (String[] args) throws ParserConfigurationException, SAXException{          //main method        

  try     

        {          

            File inputFile = new File("input.xml");     //declaration of the xml file to be parsed      

              XMLParser parser=XMLParser.newInstance();   //creation instance for parsing a document with SAX    (with Buffered InputStream) 2     

             DocumentBuilderFactory dbFactory =          //factory which creates DOM based Reader/Writer instances        

                 DocumentBuilderFactory.newInstance();      

           

              int line = 0;     //declaration and initialisation of the counter for lines          

               boolean doParse=true ;        /* flag to indicate whether we should parse or not */ 

                    try (InputStream inStream = new FileInputStream(inputFile)) {   ///try-with resource is a feature available from Java SE7     if you are using java.nio package then use the below line of code      // InputStream inStream=new FileInputStream("testfile");   

                parser.setInput(inStream, null);       /* set up input for SAX */            doParse =true;  /// reset flag           } catch (FileNotFoundException e) {   if(!doParse){ println ("XML file not found! " +e .getMessage()); return;}     

                 System.out.println("Parsing Start");    //prints start parsing    

                do{               /* begin of a loop to parse the xml */         parser.setFeature( "http://xml.org/sax/features/namespaces", true );   ///enable namespace feature         

                    try {      /***SAX event handling***/    //begin SAX parsing     XMLHandler handler = new XMLAuthorizationFailureEventXMLHandler();       parser .setContentHandler(handler);         Logger.getLogger("org.xml.sax").   setUseSystemLocale (false) ;          

                    } catch (SAXException e1 ) {                  if(!doParse){ println ("Parsing failed due to exception: " +e .getMessage()); return;}          };  //end SAX Parser      try{             parser.parse(null);     System.out.println("parsing end"); } catch (SAXException e)       {           if(!doParse){ println ("Parsing failed due to exception: " +e .getMessage()); return;}          };  //end of the main method   

                    }}catch(IOException ioe ){     ///Catch for input/output exceptions         System.out.println("Io Exception :"+ioe); }        if(!doParse){ println ("Exception while reading file: " + e .getMessage()); return;}   };  //end of the main method   

                /*if(!line)     {            line=1;               System.out.println("XML Parsing Started at Line -"+new Integer(line)); }             Document doc = parser.getDocument();       println ("--------------------- XML File Content Begin ---------------------------------");         try{          

                for (Node node :doc .getElementsByTagName ("*")) {                  //prints all elements of the xml file   System.out.println("Line: "+line);             }          };    }}catch(Exception e){              if(!doParse) println  ("Parsing failed due to exception" +e .getMessage()); return;}}