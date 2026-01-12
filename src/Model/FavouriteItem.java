package Model;

public class FavouriteItem {

    private String title;
    private String path;
    private String type; // "photo", "video", "screenshot"

    private FavouriteItem next; // linked list pointer

    public FavouriteItem(String title, String path, String type) {
        this.title = title;
        this.path = path;
        this.type = type;
        this.next = null;
    }

    public String getTitle() { return title; }
    public String getPath() { return path; }
    public String getType() { return type; }
    public FavouriteItem getNext() { return next; }
    public void setNext(FavouriteItem next) { this.next = next; }

    // ----- Linked List Operations -----
    private static FavouriteItem head = null;

    // Add to first node
    public static void addFirst(FavouriteItem item) {
        item.next = head;
        head = item;
    }

    // Add at specific index (0-based)
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

    // Remove at index
    public static void removeAt(int index) {
        if (head == null) return;
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

    // Traverse linked list
    public interface NodeHandler {
        void handle(FavouriteItem item, int index);
    }

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
