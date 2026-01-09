package Model;

import java.util.ArrayList;

public class PhotoStorages extends MediaStorage<PhotoStorages.Photo> {

    public void addPhoto(String title, String path) {
        addItem(new Photo(title, path));
    }

    public ArrayList<Photo> getPhotos() {
        return getItems();
    }

    // Inner class must match generic type
    public static class Photo extends Media {

        public Photo(String title, String path) {
            super(title, path);
        }
    }
}
