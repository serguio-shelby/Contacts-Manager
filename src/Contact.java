import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Contact {

    //private properties
    private String name;
    private String phoneNumber;

    //constructor
    public Contact(String name,String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact() {

    }

    public HashMap<String, String> readFileAndOutput (Path pathToFile) { //take in all the names and number form contacts.txt
        List<String> linesInTheFile = new ArrayList<>();// new List<String> named linesInTheFile
        try {
            linesInTheFile = Files.readAllLines(pathToFile);//reads all the line in the contacts.txt and returns a List<String>
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        HashMap<String, String> contacts = new HashMap<>();// creates a new HashMap named contacts

        for (String line : linesInTheFile){
            String[] contactArray = line.split(":");//splits contactArray by :
            contacts.put(contactArray[0],contactArray[1]);// puts the contactArray[0](name) into the HashMap contact which is the key and puts contactArray[1](phone number) into the HashMap contact which is the value
        }
        return contacts;

    }




}
