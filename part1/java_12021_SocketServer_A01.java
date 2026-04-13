import java.io.*;
import java.net.*;

public class java_12021_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000); // create server socket at port 6000
            System.out.println("Server is listening...");

            while(true) {
                Socket socket = server.accept(); // waiting for client connection

                // create streams for communication
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // get request from client
                String request = in.readUTF();

                // if request is "quit", close connection
                if(request.equals("quit")) {
                    out.writeUTF("Server has been closed");
                    out.close();
                    socket.close();
                    server.close();
                    return;
                }

                // if request is not "quit", send a response
                out.writeUTF("Server has received your message: " + request);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}