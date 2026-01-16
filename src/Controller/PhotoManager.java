package Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import Model.Photo;

/**
 * PhotoManager class - Manages photo collection with sorting and search operations.
 * Provides functionality to add photos, sort by various criteria, and search.
 *
 * @author myMemo Team
 * @version 1.0
 */
public class PhotoManager {

    /** List to store photo objects */
    private ArrayList<Photo> photos = new ArrayList<>();

    /**
     * Adds a photo to the collection.
     *
     * @param photo The Photo object to add
     */
    public void addPhoto(Photo photo) {
        photos.add(photo);
    }

    /**
     * Sorts the photo collection by title in case-insensitive alphabetical order.
     */
    public void sortByName() {
        Collections.sort(photos, Comparator.comparing(p -> p.getTitle(), 
                                                        String.CASE_INSENSITIVE_ORDER));
    }

    /**
     * Sorts the photo collection by file size in ascending order.
     */
    public void sortBySize() {
        Collections.sort(photos, Comparator.comparingInt(Photo::getSize));
    }

    /**
     * Sorts the photo collection by file type in case-insensitive alphabetical order.
     */
    public void sortByFileType() {
        Collections.sort(photos, Comparator.comparing(p -> p.getFileType(), 
                                                       String.CASE_INSENSITIVE_ORDER));
    }

    /**
     * Performs binary search to find a photo by name.
     * Note: Automatically sorts the collection before searching.
     *
     * @param name The title of the photo to search for
     * @return The Photo object if found, null otherwise
     */
    public Photo binarySearchByName(String name) {
        sortByName();
        int left = 0, right = photos.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            Photo midPhoto = photos.get(mid);
            int cmp = midPhoto.getTitle().compareToIgnoreCase(name);

            if (cmp == 0) {
                return midPhoto;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    /**
     * Retrieves the list of all photos.
     *
     * @return ArrayList containing all Photo objects
     */
    public ArrayList<Photo> getPhotos() {
        return photos;
    }
}
