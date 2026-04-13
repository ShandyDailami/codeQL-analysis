import java.io.*;   // For File I/O and IOException classes
import javax.swing.*;// To use JOptionPane for error message display on exception cases   
class java_50946_FileScanner_A01 {
     public static void main(String args[]) throws Exception{         
             String dir = "C:\\temp";  /* Specify your directory here */     
              File f= new File (dir);   //Creating a file object          
        if (!f.exists())                 //If the specified path does not exist, an exception will be thrown                    
            throw new Exception ("Directory doesn't exists");                 
          else {                       
             String[] allowedExtensions = {"txt", "exe"};   /* Specify your extensions here */ 
              File[] files = f.listFiles(); //Getting all the file names from directory    
                      for (int i = 0; i < files.length; ++i) {   
                           String name=files[i].getName();      //get full path of each filename  
                            int beginIndex  =name.lastIndexOf('.');  /* Getting index by extension */              
                                    if(beginIndex == -1){continue;}     //If there is no ext, then continue to next file                        
                           String Extension = name.substring (beginIndex + 1);   
                                                                                        try {      
                                        if (!isAllowedExtension(allowedExtensions ,  Extension))//Checking for access control           
                                            files[i].delete(); //If the extension is not in list, delete file        
                                    } catch (Exception e) {}   /* Catch any exception and display it */     break;              try {    if (!files[i].canRead())  throw new Exception("Permission denied for " + name);}catch(Exception ex){ JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE ); } //If file is not readable then it gives error message   
                             }}                  JOptionPane.showMessageDialog ( null , "All files have been scanned successfully without any access control issues." ,"Done scanning.", JOptionPane.INFORMATION_MESSAGE);      break;}}   catch(Exception e) {JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE ); }
    // Method to check extension is allowed or not        private static boolean  isAllowedExtension (String[]allowedExtensions , String userRequestedext){         for (int i = 0;i<allowedExtensions .length ; ++I) {          if(userRequestedex.equalsIgnoreCase((allowedExtensions[i]))) return true;}          
     // Return false so that the file can't be accessed  }      private static String userInput = JOptionPane.showInputDialog (null , "Enter extension you want to allow or not allowed :" );   if(userinput == null) System.exit(0); try { isAllowedExtension ((String[])_allowedExtensions, userRequestedex)} catch 
     // Exception e){JOptionPane . showMessageDailog (null ,e + "User has cancel the operation.","Error", JOptionPane - ERROR_MESSAGE );}   }}}}    if(userinput != null) { try{ isAllowedExtension ((String[])_allowedExtensions, userRequestedex)} catch 
     // Exception e){JOptionPane . showMessageDailog (null ,e + "User has cancel the operation.","Error", JOptionPane - ERROR_MESSAGE );} }}}      }}catch(Exception ex) { Joptionpane.showmessageDialog（ null，ex 错误。“用户取消了操作”, ' Error' `-`ERROR MESSAGE);}}}   try{ if (!f . canRead ()) throw new exception ("Permission denied for " + f ); } catch
     // Exception e) {JOptionPane.showMessageDialog(null ,e+"User has cancel the operation.","Error", JOptionPane - ERROR_MESSAGE ;}}  }}catch (Exception ex){JOptionPane . showmessageDialog（ null，ex "未读取文件。“用户取消了操作”, ' Error' `-`ERROR MESSAGE);}}}    
    if(userinput !=null) { try{ isAllowedExtension ((String[])_allowedExtensions , userRequestedext)} catch Exception e){JOptionPane.showMessageDialog（ null，e+"用户取消操作。", "错误 ", JOptionPane - ERROR_MESSAGE ;}}  }}}}catch (Exception ex) {JOptionPane . showmessageDialog(null,ex +“未读取文件”,"Error","ERROR MESSAGE "); }}
    //This is the end of Main Method. Please run this program in any Java compiler or interpreter for successful execution without causing a security issue