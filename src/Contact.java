import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Contact {

    //private properties
    private String name;
    private String phoneNumber;

    // constructor
    public Contact(String name,String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact() {

    }



//    public HashMap<String, String> defaultContacts() {
//        List<String> imperials = Arrays.asList("Shelby", "Serguio", "Kristen", "Kyle", "Chicha", "Roxy", "Russell", "Joshua", "Mary");
//        try {
//            Files.write(pathToOurFile, imperials);
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//        return ;
//    }

    public void readFileAndOutput (Path pathToFile) {
        List<String> linesInTheFile = new ArrayList<>();
        try {
            linesInTheFile = Files.readAllLines(pathToFile);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        for (String line : linesInTheFile){
            System.out.println(line);
        }
    }
}
