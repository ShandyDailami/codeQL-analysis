import java.io.*;   //for InputStream, OutputStream... etc   
public class java_45083_XMLParser_A07 {    
//main method      
 public static void main(String[] args) throws Exception{     
 String str;       
 FileInputStream fstream= new FileInputStream("inputFilePath");  /* replace with your input file path */   //file is read from the given input stream.   
 BufferedReader br =new BufferedReader(new InputStreamReader(fstream));      
 while((str=br.readLine()) != null){     
 System.out.println(parseXMlStringWithExceptionHandling(str, "UTF-8"));   //prints XML string content on the console   
 }         
 br.close();     /*Don't forget to close it (fstream) in a finally block or else you might get FileNotFound exceptions*/     
  }       System.out.println("Successfully parsed all xml files.");        return;   //returning control from main method                  
}    private static String parseXMlStringWithExceptionHandling(final String inputXML, final String charset) {     if (inputXML == null || "".equals(inputXML)) throw new IllegalArgumentException("Empty or Null Input");      try{  return Xml.parse(new ByteArrayInputStream(inputXML.getBytes())).toString();}catch(Exception e){   //Catching Exception and handling it while parsing the XML file     if (e instanceof SAXException) { throw new IllegalStateException("Parsing failed: " + inputXML, e); } else 
if (!isReadableFile("/path/to/file")){throw new SecurityException();}return null;    //security sensitive operation related to A07_AuthFailure     return Xml.parse(new ByteArrayInputStream((inputXML+"\uffff").getBytes())).toString() ; }
/* This method checks if the file or directory exists at given location */   private static boolean isReadableFile (String file) {      File f = new File(file);  return !(!f.exists() || (!f.isDirectory() && !f.canWrite())); }}     //returns true only when a read-write accessible path available else false }