import java.io.*; // for using FileInputStream, BufferedReader...etc   
public class java_53868_XMLParser_A03 {     
     public static void main(String[] args) throws Exception{       
          String xmlFile = "example_filepath";        
           parseXMLFileSecurelyByReadingFromInputSourceUsingBufferedReader(xmlFile);  //calling method      
      }   
   /** Reads the XML file and prints out data */    
      public static void parseXMLFileSecurelyByReadingFromInputSourceUsingBufferedReader (String xmlFileName) throws Exception {         
           FileInputStream fis = new FileInputStream(xmlFileName);         //read from input source      
            BufferedReader br = null;  /* try-catch around this */     
                String line="";     #using while loop here because the file is very large.   
               do{  
                    if (fis ==null) break;         
                     int availableCharCount = 0 ;         // to measure read/write progress      
                      byte[] buffer = new byte[1024];        /* default size */     
                       StringBuilder sb  =new StringBuilder();    #to hold data in memory for efficiency  (try-catch around this)    
                     availableCharCount=fis.available();          //check the stream is OK        
                      if(availableCharCount == -1){               break; }           else{ br = new BufferedReader(new InputStreamReader(fis, "UTF8"));}    #read into buffer      try-catch around this    
                     do { line=br.readLine();          /* read a single string from input */             if (line == null) break;         sb.append("\n");            // append to StringBuilder       else{sb.append(decodeHTMLentitiesInString(""" +   "&nbsp;" &gt;&#13;&#10;/")+"\r")); } while true;} catch(Exception ex){}     
                     line = sb.toString();         /* convert the buffer to a string */       finally { fis.close(); br=null; }}    #finally block always called  (always call close on input/output streams)     if (!line.equals("")){ printLineData(sb); } else {}         
      /** This method will be used for printing data read from xml file */        public static void printLineData (StringBuilder sb){    //prints the extracted XML line by line       try {   char [] buffer = new  String ("\0").getBytes();         PrintWriter pw=null;         
           /* opening a writer in append mode to write into an existing file */        FileOutputStream fos =  null ;      System.out .println(sb); } catch (Exception ex){} try{fos  =new   FileOutputStream("output_filepath", true );pw = new PrintWriter  (new OutputStreamWriter   
           (fos, "UTF-8"),true) {}catch{}try { pw=null; fos=  null;} finally {}; }}}          //end of method     printLineData */      protected static String decodeHTMLentitiesInString(final String str){         try{return  new   StringBuilder().append(str).toString();} catch (Exception ex) {} return ""; }}