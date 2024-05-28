import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrangChu extends JFrame {

    private JButton btnTraCuuDiem, btnXepHang;
    private JLabel lblThongTin;

    public TrangChu() {
        setTitle("2 cái vỏ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setResizable(true);

        // Tạo các thành phần
        JPanel pnlTieuDe = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lblTieuDe = new JLabel("TRANG CHỦ");
        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 24));
        pnlTieuDe.add(lblTieuDe);

        JPanel pnlLuaChon = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnTraCuuDiem = new JButton("Tra cứu điểm thi");
        btnXepHang = new JButton("Xếp hạng");
        pnlLuaChon.add(btnTraCuuDiem);
        pnlLuaChon.add(btnXepHang);

        String thongTin = "<p>Hệ thống này giúp sinh viên tra cứu điểm thi, xếp hạng học tập và cập nhật thông tin cá nhân.</p>";
                
        lblThongTin = new JLabel(thongTin);
        lblThongTin.setVerticalAlignment(SwingConstants.TOP);

        // Bố cục các thành phần
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pnlTieuDe, BorderLayout.NORTH);
        getContentPane().add(pnlLuaChon, BorderLayout.CENTER);
        getContentPane().add(lblThongTin, BorderLayout.SOUTH);

        // Thêm sự kiện cho các nút
        btnTraCuuDiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mở trang tra cứu điểm và truyền tham chiếu của TrangChu hiện tại
                new TraCuuDiem(TrangChu.this).setVisible(true); 
                setVisible(false); // Ẩn cửa sổ hiện tại
            }
        });
        

        btnXepHang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mở trang xếp hạng
                JOptionPane.showMessageDialog(null, "Chức năng xếp hạng đang được phát triển!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TrangChu().setVisible(true);
            }
        });
    }
}
