import java.io.*;
import java.net.*;

public class java_31176_SocketServer_A01 {

    private static int clientCount = 0;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started on port 8189");

        while (true) {
            Socket client = server.accept();
            clientCount++;
            System.out.println("Client #" + clientCount + " connected");

            // Handle each client separately
            new ClientHandler(client).start();
        }
    }

    public static class ClientHandler extends Thread {
        private Socket client;

        public java_31176_SocketServer_A01(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                InputStream input = client.getInputStream();
                OutputStream output = client.getOutputStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String line;

                while ((line = reader.readLine()) != null) {
                    System.out.println("Client says: " + line);

                    // Simulate a secure operation here
                    if (line.equals("break")) {
                        System.out.println("Breaking the connection");
                        client.close();
                    } else {
                        output.write("Hello client!\n".getBytes());
                    }
                }

                client.close();
                System.out.println("Client #" + clientCount + " disconnected");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}