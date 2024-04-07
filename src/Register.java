import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JDialog  {
    private JTextField textField1;
    private JTextField textFieldPhoneNumber;
    private JTextField textFieldEmail;
    private JTextField textFieldUserName;
    private JButton registerButton;
    private JPanel registerPanel;
    private JPasswordField passwordField;
    private JPasswordField passwordFieldConfirm;


    public Register(JFrame parent) {
        super(parent);
        setTitle("Register");
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validateFields()){
                    dispose();
                    String userName = textFieldUserName.getText();
                    String password = new String(passwordField.getPassword()) ;

                    User newUser = new User(userName,password);
                    UserList.addUser(newUser);
                }


            }
        });



    }


    private boolean validateFields() {
        String name = textField1.getText();
        String userName = textFieldUserName.getText();
        String password = new String(passwordField.getPassword());
        String email = textFieldEmail.getText();
        String phoneNumber = textFieldPhoneNumber.getText();

        // Check if any field is empty
        if (userName.isEmpty() || password.isEmpty() || email.isEmpty() || phoneNumber.isEmpty()  || name.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if email is valid
        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if phone number contains only numbers
        if (!phoneNumber.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid phone number (numbers only).", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Additional validations can be added here for phone number, etc.

        return true;
    }

    private boolean isValidEmail(String email) {
        // Simple email validation
        // You can implement a more sophisticated email validation if needed
        return email.contains("@") && email.contains(".");
    }
}
