import java.io.*;
import java.net.*;

public class java_14973_SocketServer_A03 {

    private static final String COMMAND = "A03_COMMAND";
    private static final int PORT = 6789;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected at: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientCommand = in.readUTF();
                if (clientCommand.equals(COMMAND)) {
                    out.writeUTF("Command received from client");
                } else {
                    out.writeUTF("Unknown command from client");
               
                }
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}