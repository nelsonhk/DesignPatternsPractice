package Adapter;

import Adapter.Contact;
import Adapter.ContactManager;

public class ContactManagerWrapper implements TableData {

    private ContactManager contactManager;

    public ContactManagerWrapper(ContactManager contactManager) {
        this.contactManager = contactManager;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return contactManager.getContactCount();
    }

    @Override
    public int getColumnSpacing() {
        return 1;
    }

    @Override
    public int getRowSpacing() {
        return 1;
    }

    @Override
    public char getHeaderUnderline() {
        return '-';
    }

    @Override
    public String getColumnHeader(int col) {
        String header = "";
        switch (col) {
            case 0:
                header = "First Name";
                break;
            case 1:
                header = "Last Name";
                break;
            case 2:
                header = "Phone";
                break;
            case 3:
                header = "Email";
                break;
        }
        return header;
    }

    @Override
    public int getColumnWidth(int col) {
        return 20;
    }

    @Override
    public Justification getColumnJustification(int col) {
        return Justification.Center;
    }

    @Override
    public String getCellValue(int row, int col) {
        Contact contact = contactManager.getContact(row);
        String cellValue = "";
        switch (col) {
            case 0:
                cellValue = contact.getFirstName();
                break;
            case 1:
                cellValue = contact.getLastName();
                break;
            case 2:
                cellValue = contact.getPhone();
                break;
            case 3:
                cellValue = contact.getEmail();
                break;
        }
        return cellValue;
    }
}
