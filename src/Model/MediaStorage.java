package Model;

import java.util.ArrayList;

/**
 * MediaStorage class - Abstract generic storage for media items.
 * Provides common operations for managing collections of media items.
 *
 * @param <T> The type of media item to store (must extend MediaStorage.Media)
 * @author myMemo Team
 * @version 1.0
 */
public abstract class MediaStorage<T extends MediaStorage.Media> {

    /** List to store media items */
    protected ArrayList<T> items;

    /**
     * Constructs an empty MediaStorage with empty item list.
     */
    public MediaStorage() {
        items = new ArrayList<>();
    }

    /**
     * Adds a media item to the storage.
     *
     * @param item The media item to add
     */
    public void addItem(T item) {
        items.add(item);
    }

    /**
     * Removes a media item at the specified index.
     *
     * @param index The index of the item to remove (0-based)
     */
    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }

    /**
     * Renames a media item at the specified index.
     *
     * @param index The index of the item to rename
     * @param newTitle The new title for the item
     */
    public void renameItem(int index, String newTitle) {
        if (index >= 0 && index < items.size()) {
            items.get(index).setTitle(newTitle);
        }
    }

    /**
     * Gets the list of all media items in storage.
     *
     * @return ArrayList containing all stored items
     */
    public ArrayList<T> getItems() {
        return items;
    }

    /**
     * Abstract base class representing a media item.
     */
    public static abstract class Media {
        /** Title of the media item */
        protected String title;
        /** File path of the media item */
        protected String path;

        /**
         * Constructs a Media item with title and path.
         *
         * @param title The title of the media item
         * @param path The file path to the media item
         */
        public Media(String title, String path) {
            this.title = title;
            this.path = path;
        }

        /**
         * Gets the title of the media item.
         *
         * @return The title
         */
        public String getTitle() {
            return title;
        }

        /**
         * Gets the file path of the media item.
         *
         * @return The file path
         */
        public String getPath() {
            return path;
        }

        /**
         * Sets the title of the media item.
         *
         * @param title The new title
         */
        public void setTitle(String title) {
            this.title = title;
        }
    }
}
