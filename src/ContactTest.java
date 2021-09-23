import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ContactTest {
    public static void main(String[] args) {

        Path pathToOurFile = Paths.get("src", "contacts.txt");

        try {
            if (Files.notExists(pathToOurFile)) {
                Files.createFile(pathToOurFile);
            } else {
                System.out.println("The " + pathToOurFile + " file already exists!");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        Contact contact = new Contact();
        contact.readFileAndOutput(pathToOurFile);

    }
}
