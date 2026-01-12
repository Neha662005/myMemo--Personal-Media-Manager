package View;

import Model.FavouriteItem;

import javax.swing.*;
import java.awt.*;

public class FavouriteCard extends JPanel {

    private JLabel titleLabel;
    private String path;

    public FavouriteCard(FavouriteItem item) {
        this.path = item.getPath();

        setPreferredSize(new Dimension(150, 150));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Image
        JLabel photoLabel = new JLabel();
        ImageIcon icon = new ImageIcon(item.getPath());
        Image img = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        photoLabel.setIcon(new ImageIcon(img));
        photoLabel.setHorizontalAlignment(JLabel.CENTER);
        photoLabel.setVerticalAlignment(JLabel.CENTER);
        add(photoLabel, BorderLayout.CENTER);

        // Title
        titleLabel = new JLabel(item.getTitle(), SwingConstants.CENTER);
        add(titleLabel, BorderLayout.SOUTH);

        // Right-click menu
        JPopupMenu menu = new JPopupMenu();
        JMenuItem deleteItem = new JMenuItem("Delete");
        deleteItem.addActionListener(e -> deleteCard());
        menu.add(deleteItem);
        setComponentPopupMenu(menu);
    }

    private void deleteCard() {
        Container parent = getParent();
        if (parent != null) {
            parent.remove(this);
            parent.revalidate();
            parent.repaint();
        }
    }

    public String getPath() { return path; }
}
