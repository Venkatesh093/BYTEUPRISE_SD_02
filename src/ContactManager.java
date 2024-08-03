import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Contact {
    String name;
    String email;
    String phone;
    String address;

    public Contact(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return name + " - " + email + " - " + phone + " - " + address;
    }
}

public class ContactManager extends JFrame {
    private JTextField nameField, emailField, phoneField, addressField;
    private DefaultListModel<Contact> contactListModel;
    private JList<Contact> contactList;

    public ContactManager() {
        // Set up the frame
        setTitle("Contact Management System");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(null);

        // Set custom fonts and colors
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);
        Color backgroundColor = new Color(245, 245, 245);
        Color buttonColor = new Color(100, 149, 237);
        Color buttonTextColor = Color.WHITE;

        // Create labels and text fields
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 80, 30);
        nameLabel.setFont(labelFont);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 20, 150, 35);
        nameField.setFont(fieldFont);
        nameField.setBorder(new RoundedBorder(10));
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 60, 80, 30);
        emailLabel.setFont(labelFont);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(100, 60, 150, 35);
        emailField.setFont(fieldFont);
        emailField.setBorder(new RoundedBorder(10));
        add(emailField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(20, 100, 80, 30);
        phoneLabel.setFont(labelFont);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(100, 100, 150, 35);
        phoneField.setFont(fieldFont);
        phoneField.setBorder(new RoundedBorder(10));
        add(phoneField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(20, 140, 80, 30);
        addressLabel.setFont(labelFont);
        add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(100, 140, 150, 35);
        addressField.setFont(fieldFont);
        addressField.setBorder(new RoundedBorder(10));
        add(addressField);

        // Create buttons
        JButton addButton = new JButton("Add Contact");
        addButton.setBounds(20, 180, 120, 30);
        addButton.setFont(labelFont);
        addButton.setBackground(buttonColor);
        addButton.setForeground(buttonTextColor);
        addButton.setOpaque(true);
        addButton.setBorder(new RoundedBorder(10));
        add(addButton);

        JButton editButton = new JButton("Edit Contact");
        editButton.setBounds(150, 180, 120, 30);
        editButton.setFont(labelFont);
        editButton.setBackground(buttonColor);
        editButton.setForeground(buttonTextColor);
        editButton.setOpaque(true);
        editButton.setBorder(new RoundedBorder(10));
        add(editButton);

        JButton deleteButton = new JButton("Delete Contact");
        deleteButton.setBounds(280, 180, 150, 30);
        deleteButton.setFont(labelFont);
        deleteButton.setBackground(buttonColor);
        deleteButton.setForeground(buttonTextColor);
        deleteButton.setOpaque(true);
        deleteButton.setBorder(new RoundedBorder(10));
        add(deleteButton);

        // Create list to display contacts
        contactListModel = new DefaultListModel<>();
        contactList = new JList<>(contactListModel);
        JScrollPane scrollPane = new JScrollPane(contactList);
        scrollPane.setBounds(20, 220, 450, 120);
        add(scrollPane);

        // Set the background color
        getContentPane().setBackground(backgroundColor);

        // Add button action
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addContact();
            }
        });

        // Edit button action
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editContact();
            }
        });

        // Delete button action
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteContact();
            }
        });
    }

    private void addContact() {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        Contact contact = new Contact(name, email, phone, address);
        contactListModel.addElement(contact);
        clearFields();
    }

    private void editContact() {
        int selectedIndex = contactList.getSelectedIndex();
        if (selectedIndex != -1) {
            Contact selectedContact = contactListModel.getElementAt(selectedIndex);
            nameField.setText(selectedContact.name);
            emailField.setText(selectedContact.email);
            phoneField.setText(selectedContact.phone);
            addressField.setText(selectedContact.address);
            contactListModel.removeElementAt(selectedIndex);
        }
    }

    private void deleteContact() {
        int selectedIndex = contactList.getSelectedIndex();
        if (selectedIndex != -1) {
            contactListModel.removeElementAt(selectedIndex);
        }
    }

    private void clearFields() {
        nameField.setText("");
        emailField.setText("");
        phoneField.setText("");
        addressField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ContactManager manager = new ContactManager();
            manager.setVisible(true);
        });
    }
}
