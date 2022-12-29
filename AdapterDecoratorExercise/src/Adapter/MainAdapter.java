package Adapter;

import Adapter.Contact;
import Adapter.ContactManager;
import Adapter.ContactManagerWrapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class MainAdapter {

    public static void main(String[] args) {

        ContactManager contactManager = new ContactManager();
        for (int i = 0; i < 5; i++) {
            Contact contact = new Contact(("FN" + i), ("LN" + i), ("PH" + i), ("EM" + i));
            contactManager.addContact(contact);
        }

        ContactManagerWrapper contactManagerWrapper = new ContactManagerWrapper(contactManager);

        Writer output = new PrintWriter(System.out);
        Table table = new Table(output, contactManagerWrapper);
        try {
            output.flush();
            table.display();
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
