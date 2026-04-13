import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39534_SocketServer_A03 {

    private int port = 12345;

    public static void main(String[] args) {
        new SocketServer().startServer();
    }

    public void startServer() {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("New client connected");

                new HandleClientThread(clientSocket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class HandleClientThread extends Thread {
        private Socket clientSocket;
        private OutputStream out;

        public java_39534_SocketServer_A03(Socket socket) {
            clientSocket = socket;
            try {
                out = clientSocket.getOutputStream();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String clientInput;

                while ((clientInput = in.readLine()) != null) {
                    // decrypt the client's input
                    String decryptedInput = decrypt(clientInput);

                    // send decrypted input back to client
                    out.write((decryptedInput + "\n").getBytes());
                    out.flush();
                }

                clientSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private String decrypt(String s) {
            // Here you can add your own decryption logic
            return s;
        }
    }
}