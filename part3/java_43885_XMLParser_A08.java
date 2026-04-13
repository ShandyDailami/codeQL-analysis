public class java_43885_XMLParser_A08 {  // start of '``'s comment block   
   private static final String TAG = "root";    
       public void parse(String file) throws Exception{     
           DocumentBuilderFactory factory = 
               DocumentBuilderFactory.newInstance();       
         /* We use a simple SAX parser that can read large files, and  */         
             Source xmlfile  = null;   // your XML file   
            try {               
                 File f = new File(file);     
                  System.out.println("Parsing: " + (f));        /* get absolute path / name of the input xml file*/                     
                   DocumentBuilder builder =  factory.newDocumentBuilder();     //Build a SAX parser from the DOM Builder   
                 ((SAXParser)builder).setProperty( 
                        "http://xml.org/sax/properties/external-generalization", "" );   /* disabling external generalizations */     
                  xmlfile = new SourceFile(f); // your input         
             } catch (Exception e1){               System.out.println("Caught Exception: File Not Found ");       return;    – stop here if file not found        case SAXParseException :            Document doc =  builder.build(xmlfile) ;   /* Use the DOM Builder to parse */                 
                 } catch (ParserConfigurationException e){             System.out.println("Caught Exception: Parser Configuration"); return;          //  stop here if there are problems with parsing configuration    case IOException :                Document doc =  builder .build(xmlfile);        /* Use the DOM Builder to parse */                   
                     } finally {           try{            XMLReader xreader =   factory.newSAXParser().getXMLReader();             Element elem=builder.parse(xreader,doc).getDocumentElement() ;  print (TAG+"( ) : " +elem);     return;    // Stop here if there are any parsing problems     
                             }catch (Exception e){                    System . out .println ("Caught Exception: Can't create SAX Parser");        /* stop on error */              }}   catch(FileNotFoundException ex) {  PrintStream ps = new PrintStream("output.txt") ;     // Write the result into a file     
                           }    finally{         DocumentBuilderFactory dbf =  factory;           XMLReader xreader=dbf .newSAXParser().getXMLReader();             Element elem=  ((DocumentBuilder)xreader).parse(doc ).getDocumentElement()   print (TAG+"( ) : " +elem);      return;}
                      } // end of public void parse method – stop here if there are any parsing problems    try {...} catch{} finally {}     in case an exception is caught or not handled, the program continues running. However it should never reach to this point unless a runtime error has been encountered during execution which makes no sense for our scenario
                      // Doing nothing as of now – we are stopping here if any exceptions were thrown and had already been dealt with above in catch blocks     }    public static void main(String args[]) { ...}   try{...}}catch{}finally {}// end program block, you can also provide a list/array to the parse method for multiple files.
Note: In real world applications xml parsing is done by SAX parser due its simplicity and speed but in this scenario we are using DocumentBuilderFactory which provides DOM based solution with more flexibility when handling XML documents as it supports SAAX(SAX) or StAX (Streaming API For XML). Also, there’s no real world application for the parsing of an entire file at once due to its large size.