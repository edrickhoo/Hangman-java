import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {

    @SuppressWarnings("unchecked")
    public static String getWordFromList() {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("wordlist.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray wordList = (JSONArray) obj;

//            Select and return random word from JSON Array
            int randomIndex = (int)Math.floor(Math.random() * wordList.size());
            return (String) wordList.get(randomIndex);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
