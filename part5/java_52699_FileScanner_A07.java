import java.io.*; // for FileScanner class java_52699_FileScanner_A07 class A07_AuthFailure {   
     public static void main(String[] args) throws IOException{       
           Scanner scan = new Scanner(System.in);     
	       System.out.print("Enter Username: ");         
		   String username=scan.nextLine();  // reading the user input        
			   
               File file =new java.io.File("/path/to//yourfile");     ## this is a placeholder, replace with your actual path     	      
                BufferedReader reader =  new BufferedReader(new FileReader (file));  		  // opening the file       	   	 			   					            				        	     	       									} }                                                  Catch block will be here if any exception occurs in main method. For example: catch (Exception e) { System..println("Some error occurred.");}