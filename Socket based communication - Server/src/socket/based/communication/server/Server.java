package socket.based.communication.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author unrealWombat
 */
public class Server {

    private int port = 22222;

    private ServerSocket server;
    private Socket client;

    // Constructor
    public Server() {
        run();
    }

    private void run() {
        try {
            System.out.println("*************************");
            System.out.println("Starting server...");

            // Open the Server Socktet.
            server = new ServerSocket(port);

            System.out.println("Waiting for client...");

            // Wait for the client request.
            client = server.accept();
            System.out.println("Connection successful! Connected to " + client.getRemoteSocketAddress());

        } catch (IOException ex) {
            System.err.println("Coudnt start server!");
        }

    }

    public void receiveData() {
        PrintWriter out = null;
        try {
            System.out.println("Waiting for input...");

            // Create I/O streams for communicating to the client.
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String inputLine = in.readLine();
            System.out.println("Client: " + inputLine);

            System.out.println("Finished receiving!");

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendData(String text) {
        PrintWriter printWriter = null;
        try {
            // Create I/O streams for communicating to the client
            printWriter = new PrintWriter(client.getOutputStream(), true);
            System.out.println("Sending to client: " + text);
            printWriter.println(text);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void closeSocket() {
        try {
            System.out.println("Closing Socket!");

            // Close the socket when done.
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
