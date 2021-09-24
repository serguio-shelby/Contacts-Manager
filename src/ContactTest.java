import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;


public class ContactTest {

    private static HashMap<String,String> contacts;

    public static void listOptions(){
        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        System.out.println("Enter an option (1, 2, 3, 4 or 5):");
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        if(userInput == 1){
            showContacts();
        } else if (userInput == 2){

        }
    }

    public static void showContacts(){
        System.out.println("Name | Phone number\n---------------\n");
        for (String key : contacts.keySet()) {
            String value = contacts.get(key);
            System.out.println(key + " | " + value);
        }
    }


    public static void main(String[] args) {
        Path pathToOurFile = Paths.get("src", "contacts.txt");
        // 1st string will be firstNameLastName
        // 2nd string will be the phoneNumber

//        for (HashMap<String, String> contact : contacts.entrySet()) {
//            String key = contact.getKey();
//            String value = contact.getValue();
        // ...
//        }
        Contact contact = new Contact();
        contacts = contact.readFileAndOutput(pathToOurFile);

        listOptions();

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
//        Contact contact = new Contact();
//        contact.readFileAndOutput(pathToOurFile);


//        public void addContact(String contact) {
//            contacts.add(contact);
    }


}
