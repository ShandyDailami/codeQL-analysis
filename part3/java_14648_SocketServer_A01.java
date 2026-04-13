import java.io.*;
import java.net.*;
import java.util.*;

public class java_14648_SocketServer_A01 {

    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {

        int port = 1234;

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server is listening on port: " + port);

            while (true) {

                Socket clientSocket = serverSocket.accept();
                clients.add(clientSocket);

                Thread clientThread = new Thread(() -> {

                    try (Socket client = clientSocket;
                         BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                         PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {

                        String clientMessage;

                        while ((clientMessage = in.readLine()) != null) {

                            System.out.println("Client says: " + clientMessage);

                            // Handle client message here
                            // For instance, we simply broadcast to all clients
                            for (Socket socket : clients) {
                                try (OutputStream outToClient = socket.getOutputStream()) {

                                    String serverMessage = "Server says: " + clientMessage;
                                    out.println(serverMessage);
                                    outToClient.println(serverMessage);
                                }
                            }
                        }

                        clients.remove(clientSocket);
                        System.out.println("Client has disconnected");

                    } catch (IOException e) {

                        e.printStackTrace();
                        clients.remove(clientSocket);
                        System.out.println("Client has disconnected");

                    }

                });

                clientThread.start();

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}