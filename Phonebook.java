package PhonebookContacts;

import java.util.ArrayList;

public class Phonebook {
    private int contactId;
    private String contactName;
    private String contactNumber;
    private ArrayList<Phonebook>phonebook = new ArrayList<>();

    public Phonebook() {
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
