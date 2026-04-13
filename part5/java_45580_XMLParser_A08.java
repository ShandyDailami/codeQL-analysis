import java.io.*;   // Import the Java IO classes needed for reading XML file and parsing it into Document object using DOM parser... etc..   
public class java_45580_XMLParser_A08 {    
static void parseXMlFile(String filename) throws ParserConfigurationException, IOException{      
//1: Obtain a factory which allows us to use the dom methods.  
DocumentBuilderFactory dbFactory = 
DocumentBuilderFactory.newInstance();      //2    ...create it... 
     DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();        //3         and parse through DOM parser (not SAX).       return;          }           catch(ParserConfigurationException e){   log(">parseXMlFile: Parser Configuration Error");      System.out.println(e);   
catch Exception e  {log (">>>Parsing error > " + filename );     //4... then print the parsing info and capture inner exception if any         }       }}               catch (IOException e)   log(">parseXMlFile: File I/O Error"); System.out.println(e);   
catch Exception  {log (">>>Error in Reading file > " + filename );     //5... then print the parsing info and capture inner exception if any         }                   return;               }}      };   public static void main (String[] args){ try{parseXMlFile("sample.xml");} catch(Exception e) { log (">>>Error in Parsing > " + Arrays.toString());     System.out.println((e));}}