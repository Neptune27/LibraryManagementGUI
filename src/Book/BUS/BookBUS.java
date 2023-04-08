package Book.BUS;

import Book.*;
import Book.DTO.Book;

import javax.swing.*;

public class BookBUS {
    private final BookDataTableModel bookDataTableModel;
    private final AuthorDataTableModel authorDataTableModel;
    private final BookGUI bookGUI;

    public BookBUS(BookDataTableModel bookDataTableModel, AuthorDataTableModel authorDataTableModel) {
        this.bookDataTableModel = bookDataTableModel;
        this.authorDataTableModel = authorDataTableModel;
        bookGUI = new BookGUI(bookDataTableModel, authorDataTableModel, this);
    }


    public void openBookEditDialog() {
        openBookEditDialog(Book.createBlankBook());
    }
    public void openBookEditDialog(int coords) {
        var book = bookDataTableModel.get(coords);
        openBookEditDialog(book);
    }

    private void openBookEditDialog(Book book) {
        var dialog = new BookEditorDialog(book, bookDataTableModel);
        dialog.pack();
        dialog.setVisible(true);
    }

    public void startGUI() {
        JFrame frame = new JFrame("Book");
        frame.setContentPane(bookGUI.getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        var authorModel = new AuthorDataTableModel();
        var bookModel = new BookDataTableModel();
        var bus = new BookBUS(bookModel, authorModel);
        bus.startGUI();
    }
}
