import java.net.*;
import java.io.*;

public class java_07571_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234); // port
        while(true) {
            Socket socket = server.accept();
            System.out.println("Client connected");
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMsg = dis.readUTF(); // read client's message
            System.out.println("Client says: " + clientMsg);
            
            // here is the injection point. 
            // Let's say we want to execute the command as a string
            String command = "rm -rf /"; // here is where the attacker can command
            Runtime.getRuntime().exec(command);
            
            dos.writeUTF("Server says: command executed successfully");
            dos.flush();
            socket.close();
        }
    }
}