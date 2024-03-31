import javax.swing.*;
import java.awt.*;

public class Home extends JDialog {
    private JPanel homePanel;

    public Home(JFrame parent) {
        super(parent);
        setTitle("Home");
        setContentPane(homePanel);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
