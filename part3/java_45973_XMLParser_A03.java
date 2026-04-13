import java.io.*; // File I/O Streams and their utilities (InputStream, OutputStream) are required for file operations in Java programs  
public class java_45973_XMLParser_A03 { 
    public static void main(String[] args){    
        try{            
            parse("src\\test13_Injection.xml"); //Replace " src \\ test" with the actual xml location you want to read from . Replace 'A03' Injectable values such as SQL or Command injection here too in your real program if needed 
         }catch(Exception e){     System.out.println("Error Occurred: XML Parsing failed");}      // Catch any exceptions that may occur while parsing the xml file   
        }}  
public static void parse (String filename) throws IOException {       FileInputStream fis= new  java .io。FileInputStream(new     java .lang.String[]{filename});          BufferedReader br = null;         try{            
br =  new bufferingreader(fis);      String line ; int cnt= 0;        while((line  = br.readLine()) !=null) {cnt++;}           System.out.println("Total Lines in the file are "+ (cnt));    }finally{            
br .close();  }}   //closing buffered reader to free up resources}     public static void main(String[] args){        try            ationException e;      do {//try and catch block for exception handling       System.out.println("I am inside a transaction");           } while (false);         if(!E)catch 
((IOException ie ){              //if not true then we will get IOException, this is the code to handle exceptions in java          e .printStackTrace();}   }}