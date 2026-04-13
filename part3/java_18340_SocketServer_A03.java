import java.io.*;
import java.net.*;

public class java_18340_SocketServer_A03 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        DataInputStream in = null;
        DataOutputStream out = null;

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                socket = server.accept();
                System.out.println("A client has connected!");

                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());

                String clientMessage = in.readUTF();
                System.out.println("Client says: " + clientMessage);

                String serverMessage = processInput(clientMessage);
                out.writeUTF(serverMessage);
                out.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static String processInput(String input) {
        // This is a placeholder for the security-sensitive operation. 
        // For this example, we just return the input in reverse order.
        return new StringBuilder(input).reverse().toString();
    }
}