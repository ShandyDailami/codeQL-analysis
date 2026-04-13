import java.net.*;
import java.io.*;

public class java_40179_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);

        System.out.println("Server is listening on port 8000");

        while(true) {
            Socket socket = serverSocket.accept();

            System.out.println("A new client is connected");

            // handle client
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();

            System.out.println("Client says: " + clientMessage);

            if(isInjectable(clientMessage)) {
                System.out.println("Injectable message detected");
                // perform injection attack
                String injectedMessage = "<script>alert('Injection Attack Detected!')</script>";
                out.writeUTF(injectedMessage);
            } else {
                out.writeUTF("Server says: " + clientMessage);
            }

            socket.close();
        }
    }

    private static boolean isInjectable(String message) {
        // Here you can implement your own logic for detecting injectable messages
        return false;
    }
}