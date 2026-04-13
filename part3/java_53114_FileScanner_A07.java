import java.io.*;  // Importing File and IOException exceptions  
        import sun.security.x509.*;     // This is only used in AUTH_FAILURE scenario, but necessary to get a certificate (A7)      
public class java_53114_FileScanner_A07 {   
      public static void main(String[] args){            
          try{                
              File f = new File("C:/path/to/" + "yourfile.txt"); // Replace with your file path here          
               if (!f.exists() || !f.canRead())  {    
                  System.out.println(“The file does not exist or you do not have permission to read it”);         return;          }      
              FileReader fr = new FileReader ( f );   // AUTH_FAILURE scenario only          
             int data;               
               while((data=fr.read()) != 1)  {                     if(new String ((char[] )buffer).equalsIgnoreCase("userName")){                             System.out.println ("Access granted for user: " + new String ( buffer)); }                         else              return;}                           }}catch(IOException e){           
               // handle the IOException           println("\nAn exception was encountered with IO operation :"+e);        continue;         };     finally {                try{ if(!f.delete() )   System.out.println ("Unable to delete file"); } catch (Exception ex)  {}      }}catch(Exception e){       // handle any other exceptions           println("\nAn exception was encountered: "+e); continue;}}
               return;}          };                  public class Main{}                      void main(){}},        try{ if(!f.delete()) System.out.println ("Unable to delete file"); } catch (Exception ex){ }}catch(IOException e) {} finally {}}}`