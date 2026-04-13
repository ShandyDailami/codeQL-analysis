import java.io.*;
import java.net.*;

public class java_14666_SocketServer_A03 {
    private static int portNumber = 1234;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(portNumber);
        System.out.println("Server started on port " + portNumber);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            // create a new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_14666_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                // read from client
                String clientMessage = reader.readLine();
                System.out.println("Received message from client: " + clientMessage);

                // write response to client
                writer.write("Thank you for connecting, message is: " + clientMessage + "\n".getBytes());
                writer.flush();

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}