package Model;

/**
 * FavouriteItem class - Represents a single favorite item in a linked list structure.
 * Stores information about favorited photos, videos, or screenshots.
 * Provides static methods for linked list operations on favorite items.
 *
 * @author myMemo Team
 * @version 1.0
 */
public class FavouriteItem {

    /** Title of the favorite item */
    private String title;
    /** File path to the favorite item */
    private String path;
    /** Type of item: "photo", "video", or "screenshot" */
    private String type;
    /** Reference to the next node in the linked list */
    private FavouriteItem next;

    /**
     * Constructs a FavouriteItem with the specified properties.
     *
     * @param title The title of the favorite item
     * @param path The file path to the item
     * @param type The type of item (photo, video, screenshot)
     */
    public FavouriteItem(String title, String path, String type) {
        this.title = title;
        this.path = path;
        this.type = type;
        this.next = null;
    }

    /**
     * Gets the title of this favorite item.
     *
     * @return The title
     */
    public String getTitle() { 
        return title; 
    }

    /**
     * Gets the file path of this favorite item.
     *
     * @return The file path
     */
    public String getPath() { 
        return path; 
    }

    /**
     * Gets the type of this favorite item.
     *
     * @return The type (photo, video, or screenshot)
     */
    public String getType() { 
        return type; 
    }

    /**
     * Gets the next node in the linked list.
     *
     * @return The next FavouriteItem, or null if this is the last node
     */
    public FavouriteItem getNext() { 
        return next; 
    }

    /**
     * Sets the next node in the linked list.
     *
     * @param next The next FavouriteItem to link
     */
    public void setNext(FavouriteItem next) { 
        this.next = next; 
    }

    /** Head pointer for the linked list of favorite items */
    private static FavouriteItem head = null;

    /**
     * Adds a favorite item to the front of the linked list.
     *
     * @param item The FavouriteItem to add
     */
    public static void addFirst(FavouriteItem item) {
        item.next = head;
        head = item;
    }

    /**
     * Adds a favorite item at a specific index in the linked list.
     * Index 0 adds at the beginning.
     *
     * @param index The position to insert the item (0-based)
     * @param item The FavouriteItem to add
     */
    public static void addAt(int index, FavouriteItem item) {
        if (index <= 0 || head == null) {
            addFirst(item);
            return;
        }
        FavouriteItem temp = head;
        for (int i = 0; i < index - 1 && temp.getNext() != null; i++) {
            temp = temp.getNext();
        }
        item.next = temp.getNext();
        temp.setNext(item);
    }

    /**
     * Removes a favorite item at a specific index from the linked list.
     *
     * @param index The position of the item to remove (0-based)
     */
    public static void removeAt(int index) {
        if (head == null) {
            return;
        }
        if (index == 0) {
            head = head.getNext();
            return;
        }
        FavouriteItem temp = head;
        for (int i = 0; i < index - 1 && temp.getNext() != null; i++) {
            temp = temp.getNext();
        }
        if (temp.getNext() != null) {
            temp.setNext(temp.getNext().getNext());
        }
    }

    /**
     * Functional interface for handling nodes during traversal.
     */
    public interface NodeHandler {
        /**
         * Handles a node during traversal.
         *
         * @param item The current FavouriteItem
         * @param index The position of the item
         */
        void handle(FavouriteItem item, int index);
    }

    /**
     * Traverses the entire linked list and applies a handler to each node.
     *
     * @param handler The NodeHandler to apply to each node
     */
    public static void traverse(NodeHandler handler) {
        FavouriteItem temp = head;
        int idx = 0;
        while (temp != null) {
            handler.handle(temp, idx);
            temp = temp.getNext();
            idx++;
        }
    }
}
