package Model;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

/**
 * PhotoStorage class - Manages storage and operations on photo collections.
 * Provides functionality to add, remove, rename, and sort photos.
 *
 * @author myMemo Team
 * @version 1.0
 */
public class PhotoStorage {
    /** List to store photo objects */
    private ArrayList<Photo> photos;

    /**
     * Constructs an empty PhotoStorage.
     */
    public PhotoStorage() {
        photos = new ArrayList<>();
    }

    /**
     * Adds a new photo to storage by title and path.
     * Creates a Photo object and adds it to the collection.
     *
     * @param title The title of the photo
     * @param path The file path to the photo
     */
    public void addPhoto(String title, String path) {
        photos.add(new Photo(title, path));
    }

    /**
     * Removes a photo at the specified index.
     *
     * @param index The index of the photo to remove (0-based)
     */
    public void removePhoto(int index) {
        if (index >= 0 && index < photos.size()) {
            photos.remove(index);
        }
    }

    /**
     * Renames a photo at the specified index.
     *
     * @param index The index of the photo to rename (0-based)
     * @param newTitle The new title for the photo
     */
    public void renamePhoto(int index, String newTitle) {
        if (index >= 0 && index < photos.size()) {
            photos.get(index).setTitle(newTitle);
        }
    }

    /**
     * Adds a Photo object at a specific index.
     *
     * @param index The position to insert the photo (0-based)
     * @param photo The Photo object to add
     */
    public void addPhotoAt(int index, Photo photo) {
        photos.add(index, photo);
    }

    /**
     * Gets the list of all photos in storage.
     *
     * @return ArrayList containing all Photo objects
     */
    public ArrayList<Photo> getPhotos() {
        return photos;
    }

    /**
     * Inner Photo class - Represents a simple photo with title and path.
     */
    public static class Photo {
        /** Title of the photo */
        private String title;
        /** File path to the photo */
        private String path;

        /**
         * Constructs a Photo with title and path.
         *
         * @param title The title of the photo
         * @param path The file path to the photo
         */
        public Photo(String title, String path) {
            this.title = title;
            this.path = path;
        }

        /**
         * Gets the title of the photo.
         *
         * @return The title
         */
        public String getTitle() {
            return title;
        }

        /**
         * Gets the file path of the photo.
         *
         * @return The file path
         */
        public String getPath() {
            return path;
        }

        /**
         * Sets the title of the photo.
         *
         * @param title The new title
         */
        public void setTitle(String title) {
            this.title = title;
        }
    }

    /**
     * Sorts the photo collection by title in case-insensitive alphabetical order.
     */
    public void sortByName() {
        Collections.sort(photos, Comparator.comparing(Photo::getTitle, 
                                                       String.CASE_INSENSITIVE_ORDER));
    }
}
