package quotes;

import com.google.gson.Gson;

import java.io.*;
import java.nio.file.*;
import java.util.Random;

public class DeserializeQuote {
    public DeserializeQuote() {
    }

    public Quotes[] Deserialize() throws IOException {

        // get input from user
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a file path: ");
        String path = br.readLine();

        // read file that exists at path the user did input
        Reader reader = Files.newBufferedReader(Paths.get(path));

        // parse file to get data from it
        Gson gson = new Gson();
        Quotes[] userArray = gson.fromJson(reader, Quotes[].class);
        reader.close();

        // print out a random data
        Random rand = new Random();
        int upperbound = userArray.length;
        int int_random = rand.nextInt(upperbound);
        System.out.println("Random quote: \"" + userArray[int_random].text + '"');


        return userArray;

    }

}
