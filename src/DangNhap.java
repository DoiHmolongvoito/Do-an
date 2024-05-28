import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DangNhap extends JFrame implements ActionListener {

    private Container container;
    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel errorMessageLabel;

    public DangNhap() {
        setTitle("2 cái vỏ");
        setBounds(300, 90, 400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        container = getContentPane();
        container.setLayout(null);

        titleLabel = new JLabel("HỆ THỐNG TRA CỨU ĐIỂM THI");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(50, 20, 300, 30);
        container.add(titleLabel);

        usernameLabel = new JLabel("MSSV:");
        usernameLabel.setBounds(50, 80, 100, 30);
        container.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 80, 200, 30);
        container.add(usernameField);

        passwordLabel = new JLabel("Mật khẩu:");
        passwordLabel.setBounds(50, 120, 100, 30);
        container.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 120, 200, 30);
        container.add(passwordField);

        loginButton = new JButton("Đăng nhập");
        loginButton.setBounds(150, 170, 100, 30);
        loginButton.addActionListener(this);
        container.add(loginButton);

        errorMessageLabel = new JLabel();
        errorMessageLabel.setForeground(Color.RED);
        errorMessageLabel.setBounds(50, 210, 300, 30);
        container.add(errorMessageLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Validate login credentials here (connect to server, check database, etc.)
            // For demonstration, assuming valid credentials
            if (username.equals("admin") && password.equals("1234")) {
                // Login successful, open homepage
                TrangChu homepage = new TrangChu();
                homepage.setVisible(true);
                dispose(); // Close login page
            } else {
                errorMessageLabel.setText("Tên người dùng hoặc mật khẩu không hợp lệ");
            }
        }
    }

    public static void main(String[] args) {
        new DangNhap();
    }
}
