package PhonebookContacts;

import javax.swing.*;
import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class MenuPhonebook {

    Scanner scanner = new Scanner(System.in);
    String userChoice = "";
    String filepath = "contactsPhonebook.txt";
    String contactName;
    String contactNumber;

    public void start() {
        showOptions();
        handleUserChoice(userChoice);
    }

    public void showOptions() {
        do {
            System.out.println("====PHONEBOOK==== " +
                    "\n1. Add a contact " +
                    "\n2. Remove PhoneBook contact " +
                    "\n3. See All PhoneBook Contacts " +
                    "\n4. Search PhoneBook contact " +
                    "\n5. Exit" +
                    "\n  Choose an option: ");
            String userChoice = scanner.nextLine();
            handleUserChoice(userChoice);
        }
        while (!userChoice.equals("5"));
        // System.exit(0);
        handleExit();
    }

    private void handleExit() {
        System.exit(0);
    }

    private void handleUserChoice(String userChoice) {
        switch (userChoice) {
            case "1":
                try {
                    System.out.println("Insert new contact name:");
                    String contactName = scanner.nextLine();
                    System.out.println("Insert phone number: ");
                    String contactNumber = scanner.nextLine();
                    createRecordsPhonebook(contactName, contactNumber, filepath);
                } catch (Exception e) {
                    System.out.println("Error cannot add a contact ");
                }
                showOptions();
                break;
            case "2":
                System.out.println("===Remove from Contacts: ===");
                viewRecords(filepath);
                System.out.println("Which contact do you want to remove? Type name: ");
                String removeTerm = scanner.nextLine();
                removeContactFromPhonebook(removeTerm, filepath);
                break;
            case "3":
                viewRecords(filepath);
                break;
            case "4":
                System.out.println("===Search Contact: ===");
                String searchRecord = scanner.nextLine();
                searchContactInPhonebook(searchRecord, filepath);
                break;
            case "5":
                System.out.println("Exiting. Good bye");
                handleExit();
                break;
            default:
                System.out.println("try again, option not implemented");
                System.out.println("Choose an option: ");
                break;
        }
        start();
    }

    private void searchContactInPhonebook(String searchRecord, String filepath) {
        /*
        boolean found = false;
        String contactName = "";
        String contactNumber = "";
        Scanner x;

        try {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext() && !found) {
                contactName = x.next();
                contactNumber = x.next();

                if (contactName.equals(searchRecord)) {
                    found = true;
                } else {
                System.out.println("Record not found");
            }

        }
        } catch (Exception e) {
            System.out.println("Error");

        } */

        boolean found = false;
        String contactName1 = "";
        //  String record = "";
        String contactName = "";
        String contactNumber = "";
        try {
            Scanner x;
            x = new Scanner((new File(filepath)));
            x.useDelimiter("[,\n]");

            while (x.hasNext() && !found)
            {
                contactName = x.next();
               contactName1 = x.next();
                contactNumber = x.next();

                if (contactName.equals(searchRecord)) {
                    found = true;
                  //  System.out.println("Contact: " + contactName1 + contactNumber);
                }
            }
            System.out.println("Contact " + searchRecord + " is found! Contact: " + contactName1 +" Number: " + contactNumber);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    private void removeContactFromPhonebook(String removeTerm, String filepath) {
        String tempFile = "temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        String contactName = "";
        String contactNumber = "";
        //   boolean found = false;

        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            Scanner x = new Scanner(new File(filepath));
            x.useDelimiter(("[,\n]"));

            while (x.hasNext()) {
                contactName = x.next();
                contactNumber = x.next();

                if (!contactName.equals(removeTerm)) {
                    pw.println(contactName + "," + contactNumber);
                } else {
                    System.out.println("Deleting: " + removeTerm);
                    System.out.println("The record was deleted successfully!");
                }
            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

  /*  private void viewRecords(String contactName, String contactNumber, String filepath) {
        Scanner myReader = new Scanner(filepath);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(filepath.lines());
        }
        myReader.close();
    } */

    public static void viewRecords(String filepath) {
        try {
            File myObj = new File(filepath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void createRecordsPhonebook(String contactName, String contactNumber, String filepath) {
        try {
            FileWriter fw = new FileWriter(filepath, true); //obj.FileWriter, if true, we put record to the list
            BufferedWriter bw = new BufferedWriter(fw);//Exception of BufferedWriter
            PrintWriter pw = new PrintWriter(bw); //like system.out

            pw.println(contactName + "," + contactNumber);
            pw.flush(); //make sure if all data is written to the file
            pw.close();//closes the stream
            //    JOptionPane.showMessageDialog(null, "Record Saved");
            System.out.println("Record saved!");

        } catch (Exception E) {
            // JOptionPane.showMessageDialog(null, "Record not saved");
            System.out.println("Record not saved!");
        }

    }


}