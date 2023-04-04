package Borrow;

import Book.Book;
import Utils.AbstractTableModelWithFilters;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BorrowModel extends AbstractTableModelWithFilters<Borrow> {
    private final String[] cols = {
            "Mã Phiếu Mượn",
            "Mã Nhân Viên",
            "Mã Độc Giả",
            "Mã Chi Tiết",
            "Ngày Mượn",
            "Ngày Trả",
            "Tổng Tiền",
    };

    private boolean isEditable = true;

    // Contructor
    public BorrowModel(boolean isEditable) {
        this();
        this.isEditable = isEditable;

    }

    public BorrowModel() {
        super();
    }

    // add data test
    public void addBlank() {
        // rows.add(Book.createTestBook());
        // fireTableRowsInserted(rows.size() - 1, rows.size() - 1);
    }

    public void addTestData() {
        // rows.add(Book.createTestBook());
        // fireTableRowsInserted(rows.size() - 1, rows.size() - 1);
    }

    public boolean isEditable() {
        return isEditable;
    }

    public void setEditable(boolean editable) {
        isEditable = editable;
    }

    // chưa hiểu
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 6) {
            return Integer.class;
        }
        return super.getColumnClass(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

    public boolean isCellEditable(int row, int column) {
        return isEditable;
    }

    public void setValueAt(Object value, int row, int col) {
        // rows.get(row).set(col, (String) value);
        fireTableCellUpdated(row, col);
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        var borrow = rows.get(rowIndex);
        return translateValue(borrow, columnIndex);

    }

    public Object translateValue(Borrow borrow, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return borrow.getId();
            }
            case 1 -> {
                return borrow.getMaNhanVien();
            }
            case 2 -> {
                return borrow.getMaDocGia();
            }
            case 3 -> {
                return borrow.getMaChiTiet();
            }
            case 4 -> {
                return borrow.getNgayMuon();
            }
            case 5 -> {
                return borrow.getNgayTra();
            }
            case 6 -> {
                return borrow.getTienTong();
            }
        }
        return null;
    }

    @Override
    public List<?> getColumnValue(int columnIndex) {
        return rows.stream().map((borrow) -> translateValue(borrow,
                columnIndex)).toList();
    }

    @Override
    public List<String> getColumnValueToString(int col) {
        // switch (col) {
        // case 2, 3, 4 -> {
        // var item = new ArrayList<String>();
        // rows.stream().map(book -> Objects.toString(translateValue(book, col)))
        // .forEach((elem) -> item.addAll(List.of(elem.split(","))));
        // return item;
        // }
        // }
        // return rows.stream().map(book -> Objects.toString(translateValue(book,
        // col))).toList();
        return null;
    }
}
