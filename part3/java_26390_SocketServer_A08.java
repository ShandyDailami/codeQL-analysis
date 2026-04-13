import java.io.*;
import java.net.*;

public class java_26390_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189); //port number
        System.out.println("Waiting for client connection...");

        Socket socket = server.accept(); //accepts the client
        System.out.println("Connected!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String line;
        while ((line = in.readLine()) != null) { //reads the client's message
            System.out.println("Received: " + line);
            if (line.equals("exit")) {
                out.writeBytes("Connection closed by client\n");
                break;
            }
            //assuming client wants to encode the message
            out.writeBytes(line + "\n");
        }

        socket.close();
        server.close();
    }
}