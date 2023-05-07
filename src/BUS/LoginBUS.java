package BUS;

import DAO.NhanVienDAO;
import DTO.nhanVien;
import javax.swing.*;
import java.util.ArrayList;

public class LoginBUS {
    private NhanVienDAO nhanVienDAO = new NhanVienDAO();
    private ArrayList<nhanVien> nvList;

    public LoginBUS() {
        nvList = nhanVienDAO.getAllFromDatabase();

        if (findHaveNhanVienQuanLy() == null) {
            nhanVien nv = new nhanVien("admin", "admin", "0123456789", "2003-01-01", "HCM", "admin@gmail.com", "admin", 1, 1, 1, 1, 30,
                    5, "012345678912");
            nhanVienDAO.AddNV(nv);
            nvList.add(nv);
        }
    }

    public boolean validateEmpty(String username, String password) {
        StringBuilder sb = new StringBuilder();

        if (username.equals("")) {
            sb.append("Chưa nhập tài khoản \n");
        }
        if (password.equals("")) {
            sb.append("Chưa nhập tên mật khẩu \n");
        }

        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(null, sb.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean login(String username, String password) {
        if (!validateEmpty(username, password)) {
            return false;
        }

        nhanVien nv = findNhanVienById(username);

        if (nv == null) {
            JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!nv.getPassword().equals(password)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu không đúng", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public void logout(JFrame frame) {
        frame.dispose();
    }

    public nhanVien findHaveNhanVienQuanLy() {
        for (nhanVien nv : nvList) {
            if (nv.getPosition() == 1) {
                return nv;
            }
        }
        return null;
    }

    public nhanVien findNhanVienById(String id) {
        for (nhanVien nv : nvList) {
            if (nv.getID().equals(id)) {
                return nv;
            }
        }
        return null;
    }

    public String findNhanVienChucVu(String id) {
        for (nhanVien nv : nvList) {
            if (nv.getID().equals(id)) {
                return nv.getPosition() == 0 ? "Thủ thư" : "Quản lý";
            }
        }
        return "";
    }
}