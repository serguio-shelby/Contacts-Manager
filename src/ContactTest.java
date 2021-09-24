import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;


public class ContactTest {
    public static void main(String[] args) {
        Path pathToOurFile = Paths.get("src", "contacts.txt");
        // 1st string will be firstNameLastName
        // 2nd string will be the phoneNumber
        HashMap<String, String> contacts = new HashMap<>();
        contacts.put("Shelby", "(605)475-6958");
        contacts.put("Serguio", "(212)479-7990");
        contacts.put("Kristen", "(655)050-8989");
        contacts.put("Kyle", "(234)678-9765");
        contacts.put("Chicha", "(219)087-6789");
        contacts.put("Roxy", "(567)890-5671");
        contacts.put("Russell", "(690)877-8833");
        contacts.put("Joshua", "(578)975-3993");
        contacts.put("Mary", "(456)789-8765");
        System.out.println(contacts.entrySet());
//        for (HashMap<String, String> contact : contacts.entrySet()) {
//            String key = contact.getKey();
//            String value = contact.getValue();
        // ...
//        }


        try {
            if (Files.notExists(pathToOurFile)) {
                Files.createFile(pathToOurFile);
            } else {
                System.out.println("The " + pathToOurFile + " file already exists!");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

//        for (String userName : students.keySet()) {
//            System.out.println(userName);
//        }
        Contact contact = new Contact();
        contact.readFileAndOutput(pathToOurFile);


//        public void addContact(String contact) {
//            contacts.add(contact);
    }


}
