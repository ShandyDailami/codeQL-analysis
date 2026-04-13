import java.io.*;
import java.net.*;

public class java_22069_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        while (true) {
            Socket socket = server.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read an integer from the client
            int x = in.readInt();

            // check if the number is greater than 100
            if (x > 100) {
                // if it is, write back "Broken!"
                out.writeUTF("Broken!");
            } else {
                // otherwise, write back "Safe!"
                out.writeUTF("Safe!");
            }

            socket.close();
        }
    }
}