import java.security.*;  // Added for KeyStoreAccess and MessageDigestSpi implementations  
...
public class java_52937_XMLParser_A01 {   
     public static void main(String[] args) throws Exception{        
          String input = "<people>\n" + "\t <person id=\"1023456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\\uD83E\\uDDFAF_xyz ABC BLAH xyz.com ID-abc+def@hackerrank.COM>\n" + "\t <name>Bob Smith</name> ... more xml content... \n " + 
          "  <group name='devteam'/>  ..."  // Security violation here - printing of untrusted data directly from external source    
       +"/people>";                    
         parse(input);    }             public static void parse (String input){          
            XMLParser xp = new XMLParser();          System.out.println("Parsing......");   // Security violation here - no logging 
                                                            for details about parsing operations      
                      try {                       if(!xp .parse(input))                     throw Exception;             }        catch (Exception e)            {" + "Security exception, can't parse XML. Please provide valid input" + 
                  "\nError message: \""+e.getMessage()+'"'}');          }}  // Security violation here - no logging     System.out .println ("Done.....");}}`; in the above code snippet are removed for simplicity and should not be used as a real program, please use it only with understanding of its purpose to avoid any security related issues