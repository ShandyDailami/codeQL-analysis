import java.io.*;
import java.net.*;

public class java_04095_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            
            String message = in.readLine();
            if (message.equals("QUIT")) {
                out.writeBytes("Connection closed\n");
                socket.close();
            } else {
                out.writeBytes("Message received: " + message + "\n");
           
            }
            serverSocket.close();
        }
    }
}