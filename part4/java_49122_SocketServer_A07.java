import java.io.*;
import java.net.*;

public class java_49122_SocketServer_A07 {  
    public static void main(String args[]) throws Exception{  //e1_AuthFailure e2a, e3b and c are contextual errors that can occur during the process of authentication (see below for more detail).      
        ServerSocket welcome = new ServerSocket(80);     //c4d - Change 'C' to an error code.   
         while (true){  
            Socket connection  = welcome.accept();  c2a, e3b and d are contextual errors that can occur during the process of accepting a client socket if there is any exception thrown by accept method or in authentication check block otherwise it will be fine as they have been removed from code below:     //c1_AuthFailure
            try{   Writer out = new OutputStreamWriter(connection.getOutputStream());  c3a, e4b and d are contextual errors that can occur during the process of sending a message to client socket if there is any exception thrown by getOutputstream method or in authentication check block otherwise it will be fine as they have been removed from code below:
                out.println("Hello Client");    //c5a, e4b and d are contextual errors that can occur during the process of sending a message to client socket if there is any exception thrown by println method or in authentication check block otherwise it will be fine as they have been removed from code below:
                out.flush();   c6d - Change 'C' to an error code, e4b and d are contextual errors that can occur during the process of flushing output stream if there is any exception thrown by flush method or in authentication check block otherwise it will be fine as they have been removed from code below:
            }catch(Exception e){   c2a_e5c, a4d and d are contextual errors that can occur during the process of sending message to client socket if there is any exception thrown by catch method or in authentication check block otherwise it will be fine as they have been removed from code below:
            }     //End try-catch.   c7a - Change 'C' into an error code, e4b and d are contextual errors that can occur during the process of sending message to client socket if there is any exception thrown by catch method or in authentication check block otherwise it will be fine as they have been removed from code below:
        }//End while.   c8a - Change 'C' into an error Code, e4b and d are contextual errors that can occur during the process of accepting client socket if there is any exception thrown by accept method or in authentication check block otherwise it will be fine as they have been removed from code below:
    } //End main.  c9a - Change 'C' into an error Code, e4b and d are contextual errors that can occur during the process of closing server socket if there is any exception thrown by close method or in authentication check block otherwise it will be fine as they have been removed from code below:
}