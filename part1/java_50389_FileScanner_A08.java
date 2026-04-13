import java.io.*; // for handling the exception

public Class Main {  

    public static void main(String[] args) throws IOException{    

        File file = new File("C:/Users/YourDirectory");// specify your directory here, replace '/' with '\'. 

         if (file.exists()) { // check whether the specified path actually exists or not  

             String filesInDir[] = file.list();    // Get all files and directories names from this folder    

              for (int i = 0; i < filesInDir.length ;i++){  // Traverse through each filename, you can use it to implement the security operations here like checking a password or key before accessing any confidential information  

                    System.out.println(filesInDir[i]);   

              }    

         } else {     

            System.out.println("The specified file does not exist.");  // if no such directory, then print appropriate message      

        }}// end of main method   and it ends here */