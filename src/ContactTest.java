import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;
import java.nio.file.StandardOpenOption;


public class ContactTest {
    static Path pathToOurFile = Paths.get("src", "contacts.txt");
    private static HashMap<String,String> contacts;

    public static void listOptions() {
        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        System.out.println("Enter an option (1, 2, 3, 4 or 5):");
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        if (userInput == 1) {
            showContacts();
        } else if (userInput == 2) {
            addContact(sc);
        } else if (userInput == 3) {
            searchContact(sc);
            listOptions();
        } else if (userInput == 4) {

        } else if (userInput == 5) {
            saveAndQuit();
        }
    }

    public static void showContacts(){
        System.out.println("Name | Phone number\n---------------");
        for (String key : contacts.keySet()) {
            String value = contacts.get(key);
            System.out.println(key + " | " + value);
        }
    }

    public static void addContact(Scanner sc) {
        System.out.println("Enter a name: ");
        String name = sc.next();
        System.out.println("Enter a phone number: ");
        String phoneNumber = sc.next();
        contacts.put(name, phoneNumber);
        System.out.println("Successfully added new contact. Type option 1 to view.");
        listOptions();
    }

//  saves the new contact to the file and then exits the program
    public static void saveAndQuit(){
        // make an empty string and loop through our contacts HashMap
        String fileString = "";
        for (String key : contacts.keySet()) {
            String value = contacts.get(key);
        fileString += key + ":" + value + "\n";
        }

    try {
        // 'Files.writeString' writes the entire new string to the file
        Files.writeString(pathToOurFile, fileString, StandardOpenOption.CREATE);
    } catch (Exception e) {
        System.out.println("ERROR: Could not save file.");
        // prints out where the error comes from
        e.printStackTrace();
        }
    }

    public static void searchContact(Scanner sc){
        System.out.println("Enter a name: ");
        String userInput = sc.next();
        try {
            //.trim() trims away any spaces
            String phoneNumber = contacts.get(userInput.trim());
            if (phoneNumber == null) {
                throw new Exception("");
            }
            System.out.println(phoneNumber);
        } catch (Exception e) {
            System.out.println("Could not find contact.");
        }
    }

        public static void main(String[] args) {
            // this is a default method that creates a file called 'contacts.txt' if one does not exist
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
        contacts = contact.readFileAndOutput(pathToOurFile);

        listOptions();



//        for (String userName : students.keySet()) {
//            System.out.println(userName);
//        }
//        Contact contact = new Contact();
//        contact.readFileAndOutput(pathToOurFile);


//        public void addContact(String contact) {
//            contacts.add(contact);
            //        for (HashMap<String, String> contact : contacts.entrySet()) {
//            String key = contact.getKey();
//            String value = contact.getValue();
            // ...
//        }

        }


}
