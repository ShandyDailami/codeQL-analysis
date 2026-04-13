import java.io.*;   // InputOutputStream and PrintWriter are included in Java IO package   
public class java_45510_XMLParser_A03 {    
 public static void main(String[] args) throws Exception  {      
         FileInputStream fis = new FileInputStream("C:/bookstore/sample.xml");     
          BufferedReader br =  new BufferedReader (new InputStreamReader(fis));   // create a buffering character input stream    default buffer size is good enough for most purposes       
           String s;       char[] cbuf = new char[1024];     int len=-1,totalLen= 0 ;     
          while((len = br.read(cbuf)) ! - 1);         totalLen += len; // accumulate the character count   System.out .println("Total read characters : " + (char)('\u'+ cbuf));    for (; ((s=br.readLine())!=  null ) ; s = br.readLine()){           
           if(null==XML_content && !"".equalsIgnoreCase((new String(cbuf,0 ,len)).trim())){ // Checking xml tag open and close         XML_started =  true;        currline=s;}             System .out  .print (currline); }
           if(!xmlContent.contains("<books>") && !"".equalsIgnoreCase((new String(cbuf,0 ,len)).trim())){ // Checking books tag open and close              xmlStarted = true;        currlines=s;} System .out  print (currline); }
           if(!XML_content.contains("</books>") && !"".equalsIgnoreCase((new String(cbuf,0 ,len)).trim())){ // Checking books tag close and open              xmlStarted = true;        currlines=s;} System .out  print (currline); }
           if(!XML_content.contains("<book>") && !"".equalsIgnoreCase((new String(cbuf,0 ,len)).trim())){ // Checking book details open and close             xmlStarted = true;        currlines=s;} System .out  print (currline); }
           if(!XML_content.contains("</book>") && !"".equalsIgnoreCase((new String(cbuf,0 ,len)).trim())){ // Checking book details close and open             xmlStarted = true;        currlines=s;} System .out  print (currline); }
           if(!XML_content.contains("<price>") && !"".equalsIgnoreCase((new String(cbuf,0 ,len)).trim())){ // Checking book price open and close            xmlStarted = true;        currlines=s;} System .out  print (currline); }
           if(!XML_content.contains("</price>") && !"".equalsIgnoreCase((new String(cbuf,0 ,len)).trim())){ // Checking book price close and open             xmlStarted = true;        currlines=s;} System .out  print (currline); }
           if(!XML_content.contains("<author>") && !"".equalsIgnoreCase((new String(cbuf,0 ,len)).trim())){ // Checking book author open and close             xmlStarted = true;        currlines=s;} System .out  print (currline); }
           if(!XML_content.contains("</author>") && !"".equalsIgnoreCase((new String(cbuf,0 ,len)).trim())){ // Checking book author close and open             xmlStarted = true;        currlines=s;} System .out  print (currline); }
           if(!XML_content.contains("</bookstore>") && !"".equalsIgnoreCase((new String(cbuf,0 ,len)).trim())){ // Checking book store close and open             xmlStarted = true;        currlines=s;} System .out  print (currline); }
         br.close();    fis.close():      }}`   f}