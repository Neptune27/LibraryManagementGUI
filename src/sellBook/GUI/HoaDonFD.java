package sellBook.GUI;

import sellBook.BUS.SellTicketBus;
import sellBook.DTO.HoaDon;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class HoaDonFD extends JDialog {
    private JPanel contentPane;
    private JButton btnRemove;
    private JButton btnCancel;
    private JPanel mainPanel;
    private JTextField txtMaNV;
    private JTextField txtMaKH;
    private JTextField txtMaPhieu;
    private JButton addButton;
    private JButton updateButton;
    private JPanel tacGiaPanel;
    private JTextField txtTenKH;

    private HoaDonGUI gui ;

    SellTicketBus bus = new SellTicketBus();


    public HoaDonFD(HoaDonGUI gui) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnRemove);
        this.gui = gui;
        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maPhieu = txtMaPhieu.getText();
                String maNV = txtMaNV.getText();
                String maKH = txtMaKH.getText();
                HoaDon hd =new HoaDon();
                hd.setMa_KH(maKH);
                hd.setMa_phieu(maPhieu);
                hd.setMa_nv(maNV);
                int smt = bus.insert(hd);
                if(smt>0){
                    JOptionPane.showMessageDialog(null,"Them Hoa Don thanh cong");
                    gui.showAll();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Them Hoa Don KHONG THANH CONG");
                }
            }
        });

        txtMaKH.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String tenKH = bus.goiYNameKH(txtMaKH.getText());
                txtTenKH.setText(tenKH);
            }
        });
    }

    public HoaDonFD(String maHD,HoaDonGUI gui){

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnRemove);
        this.gui = gui;

        List<HoaDon>  bill = bus.filterMaHD(maHD);
        System.out.println(maHD+"  "+bill.size());

        HoaDon ticket = bill.get(0);
        txtMaPhieu.setText(ticket.getMa_phieu());
        txtMaKH.setText(ticket.getMa_KH());
        txtMaNV.setText(ticket.getMa_nv());
        txtTenKH.setText(ticket.getTenKH());

        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maPhieu = txtMaPhieu.getText();
                String maNV = txtMaNV.getText();
                String maKH = txtMaKH.getText();
                HoaDon hd =new HoaDon();
                hd.setMa_KH(maKH);
                hd.setMa_phieu(maPhieu);
                hd.setMa_nv(maNV);
                int smt = bus.insert(hd);
                if(smt>0){
                    JOptionPane.showMessageDialog(null,"Them Hoa Don thanh cong");
                    gui.showAll();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Them Hoa Don KHONG THANH CONG");
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maHD = txtMaPhieu.getText();
                String maNV =txtMaNV.getText();
                String maKH = txtMaKH.getText();
                HoaDon hd = new HoaDon();
                hd.setMa_nv(maNV);
                hd.setMa_phieu(maHD);
                hd.setMa_KH(maKH);
                int smt = bus.update(hd);
                if(smt>0){
                    JOptionPane.showMessageDialog(null,"Cap Nhat Hoa Don thanh cong");
                    dispose();
                    gui.showAll();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Cap Nhat Hoa Don KHONG THANH CONG");
                }
            }
        });


        txtMaKH.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String tenKH = bus.goiYNameKH(txtMaKH.getText());
                txtTenKH.setText(tenKH);
            }
        });

    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

//    public static void main(String[] args) {
//        HoaDonFD dialog = new HoaDonFD();
//        dialog.pack();
//        dialog.setVisible(true);
//        System.exit(0);
//    }
}
