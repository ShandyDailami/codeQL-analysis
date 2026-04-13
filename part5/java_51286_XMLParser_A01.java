import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_51286_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{          
        // Create a new instance of the XMLReader         
        XMLReader reader = null;        
  try {            
            Reader fileOut=new FileReader("input.xml");               
              StringBuilder sb=null;                    
   while (fileOut.ready()){                     
       int data=fileOut.read();                       
               if(sb==null)                         //If the first time, initialize stringbuilder                  else add to it                         
                       sb = new StringBuilder(1024);                           
                   do{if((data<=127))                     {                               break; }                             data=fileOut.read();                           appenderCharacters (Character . chr (     ((int) ​into the character buffer                         [ ]),      //append characters to sb              return   stringbuffer(sb);   
                } catch (Exception ex){                      System..println ("Problem in parsing xml file: " +ex.getMessage());}          };             reader=null;                 try{reader =     SAXReader . newInstance();                             ConsoleWriter ​wrtier=  null;}catch   .....(exception e) {System outprint (e);exit    program      }           
               if (!sb.toString().equals(""))        System..println ("XML has been parsed successfully");         else{                                           Printwriter . println     {"Unable to parse XML file"};}                                                                  exit Program;                };                     catch   .....(Exception e){System outprint (e);exit    program      }         
public static void appendCharactersToStringBuilder(String str, StringBuffer sb) {              for        char[] ca =         {' ',' ',',''}{           int len=0 ;            try{len=  CharSequence.length ​os;             if   s       .equalsIgnoreCase     (str)){          sa      .....    a                  }catch(Exception ex){System..println("Problem in appending: " +ex.getMessage());}