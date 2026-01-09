package Model;
import java.util.ArrayList;

public abstract class MediaStorage<T extends MediaStorage.Media> {

    protected ArrayList<T> items;

    public MediaStorage() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }

    public void renameItem(int index, String newTitle) {
        if (index >= 0 && index < items.size()) {
            items.get(index).setTitle(newTitle);
        }
    }

    public ArrayList<T> getItems() {
        return items;
    }

    // Base Media class
    public static abstract class Media {
        protected String title;
        protected String path;

        public Media(String title, String path) {
            this.title = title;
            this.path = path;
        }

        public String getTitle() {
            return title;
        }

        public String getPath() {
            return path;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
