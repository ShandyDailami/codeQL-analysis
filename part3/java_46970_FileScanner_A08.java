import java.io.*; //Importing file handling operations  
class java_46970_FileScanner_A08 {    
    public static void main(String args[]) throws IOException{ 
        File folder = new File(".");//get the current directory           
		int sum = 0;            
	    for (File file : folder.listFiles((dir, name) -> //checking only .txt files  
	        name.endsWith(".txt"))){   
			if(file != null && (!file.isHidden())){        
				for (int i = sum = 0; ; ++i %= 26 ) {  /*sum of asci values for alphabets*/     
                    if ((char) ('A' + i) == file.getName().charAt(1)) //integrity check               
                        break;                      }           setPermission(file, "rw-");             System.out.println("Permissions are:  ");               println("\t"+ (i + 256 ) %  26 + "-> A : Name:"  + file .getName());            }}         //If the sum of asci values for filename is less than zero or more then it's corrupted
    }}}`. Please note that this code does not handle permissions, integrity checks and other security-sensitive operations related to 'A08_IntegrityFailure'. It simply provides a way around your request by presenting an example of how you can implement such functionality in vanilla java with standard libraries only (File handling).