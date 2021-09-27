import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.nio.file.StandardOpenOption;


public class ContactTest {
    static Path pathToOurFile = Paths.get("src", "contacts.txt");
    private static HashMap<String, String> contacts;

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
            listOptions();
        } else if (userInput == 2) {
            addContact(sc);
        } else if (userInput == 3) {
            searchContact(sc);
            listOptions();
        } else if (userInput == 4) {
            deleteContacts(sc);
            listOptions();
        } else if (userInput == 5) {
            saveAndQuit();
        }
    }

    public static void showContacts() {
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
        boolean enterContactInfo = true;
        if (contacts.get(name) != null) {//if the name matches any on the contacts keys it will run the following code
            System.out.println("There's already a contact named " + name + ". Do you want to overwrite it? (Yes/No)");
            String yesOrNo = sc.next();
            if (yesOrNo.equalsIgnoreCase("no")) {// if no will make enterContactInfo false it will return you to the main menu
                enterContactInfo = false;
                listOptions();
            } else {
                listOptions();//this will run after line 63 is finished
            }
        }
        if (enterContactInfo) {
            if (phoneNumber.length() == 7) {//phoneNumber must equal 7
                String formatPhoneNumber = phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3);//the first phoneNumber.substring(0, 3) adds a - after index 3 the last phoneNumber.substring(3) adds the rest of the numbers in the phone number.
                contacts.put(name, formatPhoneNumber);
                System.out.println("Successfully added new contact. Type option 1 to view.");
                listOptions();
            } else if (phoneNumber.length() == 10) {//phoneNumber must equal 10
                String formatPhoneNumber = phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6);
                //the first phoneNumber.substring(0, 3) adds a - after index 3 the second phoneNumber.substring(3, 6) starts at index 3 and gos to index 6 after index it will add a - the last phoneNumber.substring(6) adds the rest of the numbers in the phone number.
                contacts.put(name, formatPhoneNumber);
                System.out.println("Successfully added new contact. Type option 1 to view.");
                listOptions();
            } else {
                System.out.println("This phone number is invalid\nTry again");
                addContact(sc);
            }
        }

}

    //  saves the new contact to the file and then exits the program
    public static void saveAndQuit() {
        // make an empty string and loop through our contacts HashMap
        String fileString = "";
        for (String key : contacts.keySet()) {
            String value = contacts.get(key);
            fileString += key + ":" + value + "\n";//adds key and value to filesSting
        }

        try {
            // 'Files.writeString' writes the entire new string to the file
            Files.writeString(pathToOurFile, fileString, StandardOpenOption.CREATE);//this recreates the contacts.txt with fileSting added to it
        } catch (Exception e) {
            System.out.println("ERROR: Could not save file.");
            // prints out where the error comes from
            e.printStackTrace();
        }
    }

    public static String searchContact(Scanner sc) {
        System.out.println("Enter a name: ");
        String userInput = sc.next().trim();
        try {
            //.trim() trims away any spaces
            String phoneNumber = contacts.get(userInput);//contacts.get(userInput) is the same as saying contacts.get(key)
            if (phoneNumber == null) {
                throw new Exception("");
            }
            System.out.println(phoneNumber);//if finds the number than it will print out then number of named typed in
            return userInput;
        } catch (Exception e) {
            System.out.println("Could not find contact.");
            return null;
        }
    }

    public static void deleteContacts(Scanner sc) {
        String userInput = searchContact(sc);//takes user input
        if (userInput != null) {
            contacts.remove(userInput);// this removes it form contacts.txt
            System.out.println("Successfully deleted " + userInput);
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
    }


}
