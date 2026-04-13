import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_30667_SocketServer_A03 {

    private static ExecutorService executor;

    public static void main(String[] args) {

        //Initialize executor
        executor = Executors.newCachedThreadPool();

        try {
            //Create a server socket
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server started at port 8080");

            while (true) {
                //Accept a new client
                Socket client = server.accept();
                System.out.println("Client connected at port " + client.getPort());

                //Create a new thread for the client
                executor.execute(new ClientHandler(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //Shutdown executor
            executor.shutdown();
        }
    }

    static class ClientHandler implements Runnable {

        private Socket clientSocket;

        public java_30667_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                //Create input and output streams
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                //Send a welcome message
                out.writeUTF("Welcome to Secure Server!\n");

                //Handle client messages
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    //Process the message here using injection free code
                    //This is just a placeholder, actual code will depend on the injection
                    //Free code. If we have a security vulnerability, it would be here.

                    //Send a response back to the client
                    out.writeUTF("Thank you for contacting us!\n");
                }

                //Close the connection
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}