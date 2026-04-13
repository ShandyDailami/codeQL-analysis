import java.net.*;
import java.io.*;

public class java_18540_SocketServer_A01 {
    public static void main(String args[]) {
        try {
            ServerSocket server = new ServerSocket(6000);
            while(true) {
                Socket s = server.accept();

                // Reading data from client
                BufferedReader in = new BufferedReader(
                  new InputStreamReader(s.getInputStream()));
                System.out.println("Client connected: " + in.readLine());

                // Sending data to client
                PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                out.println("Hello, Client, You are connected to the server!");

                s.close();
            }
        } 
        catch (IOException e) {
            System.out.println(e);
        }
    }
}