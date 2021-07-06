package quotes;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DeserializeQuote {
    public DeserializeQuote() {
    }

    public Quotes[] Deserialize(String path) throws IOException {

        Gson gson = new Gson();

        Reader reader = Files.newBufferedReader(Paths.get(path));

        Quotes[] userArray = gson.fromJson(reader, Quotes[].class);

        System.out.println(userArray[1].text);

        reader.close();
        return userArray;

    }

}
