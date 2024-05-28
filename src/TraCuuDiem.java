import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class TraCuuDiem extends JFrame {

    private JTextField txtMSSV;
    private JButton btnTraCuu, btnThoat;
    private JTable tblKQ;
    private TrangChu trangChu; // Tham chiếu đến đối tượng TrangChu

    public TraCuuDiem(TrangChu trangChu) {
        this.trangChu = trangChu; // Lưu trữ tham chiếu TrangChu
        setTitle("Tra cứu điểm thi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Đặt hành vi đóng mặc định
        setSize(600, 400);
        setResizable(false);

        // Tạo các thành phần
        JPanel pnlNhapMSSV = new JPanel(new FlowLayout());
        pnlNhapMSSV.add(new JLabel("MSSV: "));
        txtMSSV = new JTextField(20);
        pnlNhapMSSV.add(txtMSSV);

        JPanel pnlTraCuu = new JPanel(new FlowLayout());
        btnTraCuu = new JButton("Tra cứu");
        btnThoat = new JButton("Quay Lại");
        pnlTraCuu.add(btnTraCuu);
        pnlTraCuu.add(btnThoat);

        String[] columnNames = {"Mã môn học", "Tên môn học", "Hệ số tín chỉ", "Điểm thi", "Điểm thi lại"};
        Object[][] data = {}; // Dữ liệu sẽ được lấy từ máy chủ
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        tblKQ = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tblKQ);

        // Bố cục các thành phần
        getContentPane().setLayout(new GridLayout(3, 1, 5, 5));
        getContentPane().add(pnlNhapMSSV);
        getContentPane().add(pnlTraCuu);
        getContentPane().add(scrollPane);

        // Thêm trình lắng nghe sự kiện
        btnTraCuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Triển khai logic để lấy dữ liệu điểm từ máy chủ dựa trên MSSV đã nhập
                // Cập nhật tblKQ với dữ liệu đã lấy
                // Hiển thị thông báo lỗi nếu cần thiết
            }
        });

        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (trangChu != null) {
                    trangChu.setVisible(true); // Hiển thị cửa sổ TrangChu
                    dispose(); // Đóng cửa sổ TraCuuDiem
                } else {
                    System.out.println("Đối tượng TrangChu không được cung cấp!");
                    // Cân nhắc hành vi thay thế nếu TrangChu không có sẵn
                }
            }
        });
    }

    public TraCuuDiem() {
        //TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        // Ví dụ sử dụng (giả sử bạn có đối tượng TrangChu)
        TrangChu mainWindow = new TrangChu(); // Tạo phiên bản TrangChu
        new TraCuuDiem(mainWindow).setVisible(true);
    }
}
