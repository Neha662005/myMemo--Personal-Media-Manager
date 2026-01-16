package View;

import Model.FavouriteItem;

import javax.swing.*;
import java.awt.*;

/**
 * FavouriteCard is a custom JPanel component that displays a favorite media item.
 * It shows a thumbnail image with a title and provides a right-click context menu for deletion.
 * This component is typically used in a grid or list layout to display favorite items.
 *
 * 
 * Features:
 * 
 *   Displays thumbnail image of the favorite item
 *   Shows item title below the image
 *   Right-click menu for deleting the card
 *   Automatic image scaling to fit panel dimensions
 * 
 * 
 *
 * @author HP
 * @version 1.0
 * @see FavouriteItem
 */
public class FavouriteCard extends JPanel {

    private JLabel titleLabel;
    private String path;

    /**
     * Constructs a FavouriteCard with the given FavouriteItem.
     * Initializes the card with the item's image and title, and sets up the right-click context menu.
     *
     * @param item The FavouriteItem to display in this card
     */
    public FavouriteCard(FavouriteItem item) {
        this.path = item.getPath();

        setPreferredSize(new Dimension(150, 150));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Image - Creates and displays the scaled thumbnail image
        JLabel photoLabel = new JLabel();
        ImageIcon icon = new ImageIcon(item.getPath());
        Image img = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        photoLabel.setIcon(new ImageIcon(img));
        photoLabel.setHorizontalAlignment(JLabel.CENTER);
        photoLabel.setVerticalAlignment(JLabel.CENTER);
        add(photoLabel, BorderLayout.CENTER);

        // Title - Displays the item name at the bottom of the card
        titleLabel = new JLabel(item.getTitle(), SwingConstants.CENTER);
        add(titleLabel, BorderLayout.SOUTH);

        // Right-click menu - Context menu for card operations
        JPopupMenu menu = new JPopupMenu();
        JMenuItem deleteItem = new JMenuItem("Delete");
        deleteItem.addActionListener(e -> deleteCard());
        menu.add(deleteItem);
        setComponentPopupMenu(menu);
    }

    /**
     * Removes this card from its parent container and updates the display.
     * Called when the user selects the "Delete" option from the context menu.
     */
    private void deleteCard() {
        Container parent = getParent();
        if (parent != null) {
            parent.remove(this);
            parent.revalidate();
            parent.repaint();
        }
    }

    /**
     * Gets the file path of the favorite item displayed in this card.
     *
     * @return The file path string of the favorite item
     */
    public String getPath() { 
        return path; 
    }
}
