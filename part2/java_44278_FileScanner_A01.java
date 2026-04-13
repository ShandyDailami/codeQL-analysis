import java.io.*;
class java_44278_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{      
        String dir = "/path/to/directory"; // Replace with your directory path here 
         File folder = new File(dir);    
          for (File file : folder.listFiles()) {            
            if(!file.canRead() || !SecurityUtils.isPermissionSetCorrectly(file, "754")){                     
                continue;    // Ignore files that are not readable or have incorrect permission levels              
              }  else  
                   System.out.println("Content of file: ");    
                    printFileContentsWithoutHeaderFooter(new FileReader (file));                      
          }}     
        private static void printFileContentsWithoutHeaderFooter(FileReader fr) throws IOException {        
            BufferedReader br = new BufferedReader(fr);      
             String line;   while ((line=br.readLine()) !=  null){    // Reads file content    
                 System.out.println("Content of File: " + "\n"+ line );  }}}     
           private static boolean isPermissionSetCorrectly(File f,String permission) {       return (f.setReadable(true , false ) &&        SecurityUtils.isValidMaskSetting(permission)); }}    class SecurityUtils{     public final static String VALID_PERMISSIONS="754";      private  static boolean isNumericPermissionTestFailed =false;  
             //Checks if permission string has numeric value,if yes return false else true.      
            /*public */static Boolean IsValidMaskSetting (String maskedpermission){        String[] splitMasks=maskedpermission .split("");    for(int i= 0 ;i< 4; +++ ){         if (!isNumericPermissionTestFailed && !SecurityUtils.IsNumberValue((new Integer)(Integer.parseInt(  
              sortPermissions[ (sortIndex++) % splitMasks].getValue()]))){                 isNumericpermissiontestfailed =true ; return false;}else                    setnumericheck= true; }return  truenumericec permission test failed:false}}     //checks if the masked permissioN value exists in VALID_PERMISSIONS and it has numerics.  
        private static boolean isNumericValue(Integer num){      return (num>=0 && num<=9); }  }}