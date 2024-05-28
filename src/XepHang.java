import java.swing.*;
import java.awt.*;
import java.awt.event.*;

public class XepHang extends JFrame {

    private JTable tblXepHang;

    public XepHang() {
        setTitle("Xếp hạng");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);

        // Tạo bảng xếp hạng
        String[] columnNames = {"STT", "MSSV", "Họ tên", "Điểm trung bình"};
        Object[][] data = {}; // Dữ liệu xếp hạng sẽ được lấy từ server
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        tblXepHang = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tblXepHang);

        // Bố cục giao diện
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Lấy dữ liệu xếp hạng từ server (chưa thực thi)
        // Cập nhật dữ liệu vào bảng xếp hạng
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new XepHang().setVisible(true);
            }
        });
    }
}
