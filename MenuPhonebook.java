package PhonebookContacts;

import phonebook.Contact;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuPhonebook {

    Scanner scanner = new Scanner(System.in);
    String userChoice = "";
    String filepath = "contactsPhonebook.txt";
    int contactId;
    String contactName;
    String contactNumber;
    private ArrayList<Contact>contacts = new ArrayList<>();


    public void start() {
        do {
            System.out.println("====PHONEBOOK==== " +
                    "\n1.Add a contact " +
                    "\n2.Remove PhoneBook contact " +
                    "\n3.See PhoneBook Contact " +
                    "\n4.Search PhoneBook contact " +
                    "\n5.Exit");
            System.out.println("Choose an option: ");
            String userChoice = scanner.nextLine();
            handleUserChoice(userChoice);
        } while (!userChoice.equals("5"));

    }

    private void handleExit() {
        System.exit(0);
    }

    private void handleUserChoice(String userChoice) {
        switch (userChoice) {
            case "1":
                addContactToPhonebook();
                break;
            case "2":
        //        removeContactFromPhonebook();
            case "3":
          //      seeContactInPhonebook();
            case "4":
           //     searchContactInPhonebook();
            case "5":
                System.out.println("Exiting. Good bye");
                handleExit();
                break;
            default:
                System.out.println("try again, option not implemented");
                break;
        }
    }

    public void addContactToPhonebook() {

      do{
          System.out.println("Insert new contact name:");
        String contactName = scanner.nextLine();
        System.out.println("Insert phone number: ");
        String contactNumber = scanner.nextLine();
        createRecordsPhonebook(getContactId(), contactName, contactNumber, filepath);
      }while (scanner.hasNextLine());
        handleExit();
    }

    public int getContactId() {
        return this.contacts.size()>0
                ? contacts.get(contacts.size() - 1). getId()+1
                :1;
    }

    private void createRecordsPhonebook(int contactId, String contactName, String contactNumber, String filepath){
       // Contact contactToAdd = new Contact();
        try {
            FileWriter fw = new FileWriter(filepath, true); //obj.FileWriter, if true, we put record to the list
            BufferedWriter bw = new BufferedWriter(fw);//Exception of BufferedWriter
            PrintWriter pw = new PrintWriter(bw); //like system.out

            pw.println(contactId + "," + contactName + "," + contactNumber);
            pw.flush(); //make sure if all data is written to the file
            pw.close();//closes the stream

            JOptionPane.showMessageDialog(null, "Record Saved");

        }catch (Exception E){
                JOptionPane.showMessageDialog(null, "Record saved");
            }

    }
}