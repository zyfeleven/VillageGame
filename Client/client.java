package Client;

import Exception.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client {
    //main
    public static void main(String[] args) throws InvalidOptionException {

        Request.sendRequest("1","1",8888);
//        Game game = new Game();
//        game.main();
    }
}
