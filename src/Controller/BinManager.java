package Controller;

import javax.swing.JPanel;
import java.awt.Component;

/**
 * BinManager class - Manages deleted items using a queue data structure.
 * Implements functionality to add, remove, and retrieve items from a bin (trash).
 *
 * @author myMemo Team
 * @version 1.0
 */
public class BinManager {

    /** Queue to store components in the order they were deleted */
    private MyQueue<Component> binQueue;
    /** JPanel display component for the bin */
    private JPanel clBin;

    /**
     * Constructs a BinManager with a specified JPanel for display.
     *
     * @param clBin The JPanel to display bin contents
     */
    public BinManager(JPanel clBin) {
        this.clBin = clBin;
        binQueue = new MyQueue<>();
    }

    /**
     * Adds a component to the bin.
     * Removes the component from its current parent if present.
     *
     * @param card The component to add to the bin
     */
    public void addToBin(Component card) {
        // Remove from current parent if needed
        if (card.getParent() != null) {
            card.getParent().remove(card);
        }

        // Add to queue
        binQueue.enqueue(card);

        // Add to display panel and refresh
        clBin.add(card);
        clBin.revalidate();
        clBin.repaint();
    }

    /**
     * Removes a component from the bin display panel.
     * Note: Does not remove from the queue.
     *
     * @param card The component to remove from display
     */
    public void removeFromBin(Component card) {
        clBin.remove(card);
        clBin.revalidate();
        clBin.repaint();
    }

    /**
     * Dequeues and removes the first component from the bin.
     * Follows FIFO (First In First Out) order.
     *
     * @return The first component in the bin, or null if bin is empty
     */
    public Component dequeueFromBin() {
        Component card = binQueue.dequeue();
        if (card != null) {
            clBin.remove(card);
            clBin.revalidate();
            clBin.repaint();
        }
        return card;
    }
}
