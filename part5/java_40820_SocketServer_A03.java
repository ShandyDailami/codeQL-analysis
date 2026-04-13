import java.io.*;
import java.net.*;
import java.util.*;

public class java_40820_SocketServer_A03 {
    private static final String SERVER_SOFTWARE = "SecureSocketServer/1.0";
    private static final int PORT = 9876;

    private static class Handler extends Thread {
        private Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                OutputStream out = socket.getOutputStream();
                DataOutputStream dataOut = new DataOutputStream(out);
                InputStream in = socket.getInputStream();
                DataInputStream dataIn = new DataInputStream(in);

                String clientMessage;
                while ((clientMessage = dataIn.readUTF()) != null) {
                    System.out.println("Client says: " + clientMessage);
                    if (clientMessage.equals("exit")) {
                        dataOut.writeUTF("Server says: Bye!");
                        dataOut.flush();
                        socket.close();
                        System.out.println("Connection closed");
                        return;
                    }
                    dataOut.writeUTF("Server says: Hello, client!");
                    dataOut.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New connection from " + socket.getRemoteSocketAddress());
            new Handler(socket).start();
        }
    }
}