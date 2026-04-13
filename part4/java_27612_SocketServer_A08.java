import java.io.*;
import java.net.*;

public class java_27612_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received: " + message);

            if (message.equals("exit")) {
                break;
            }

            output.writeUTF("Thank you for connecting");
            output.flush();
       
        }

        server.close();
    }
}