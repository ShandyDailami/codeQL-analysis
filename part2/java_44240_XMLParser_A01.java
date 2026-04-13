import java.io.*; // For Input/Output Stream classes 
  
public class java_44240_XMLParser_A01 {     
    public static void main(String[] args) throws Exception{        
        File inputFile = new File("sample_file");    
            if (inputFile.exists())         
                parseXMlFile(inputFile);           else             System.out.println("\nError: Unable to open file sample_xml for reading.");  end;   // Close the connection and stream objects in this order        }    public static void parseXMLfile(InputStream inputStream) throws Exception {         
            int content = 0 ;                  InputStreamReader reader = null;              BufferedReader bufferedReader=null ;             try{               if (inputFile.exists())   // Check whether a file with the same name exists or not  return false;} else                 System.out.println("\nError: Unable to open input stream for reading");                     } finally {    
                reader .close();      bufferedReader = null;              }}// end of parseXMLFile method}public static void main(String[] args) throws Exception{         File myInputfile =  new  //new InputStream("sample_xml")   if (myinputstream.exists())          parselXMlInputStream(myInPutSream);           else             System .outprintln("\nError: Unable to open input stream for reading"); }