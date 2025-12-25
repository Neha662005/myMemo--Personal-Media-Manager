package Model;

import java.util.ArrayList;

public class PhotoStorage {
    private ArrayList<Photo> photos;

    public PhotoStorage() {
        photos = new ArrayList<>();
    }

    public void addPhoto(String title, String path) {
        photos.add(new Photo(title, path));
    }

    public void removePhoto(int index) {
        if (index >= 0 && index < photos.size()) {
            photos.remove(index);
        }
    }

    public void renamePhoto(int index, String newTitle) {
        if (index >= 0 && index < photos.size()) {
            photos.get(index).setTitle(newTitle);
        }
    }

    public ArrayList<Photo> getPhotos() {
        return photos;
    }

    // Inner Photo class
    public static class Photo {
        private String title;
        private String path;

        public Photo(String title, String path) {
            this.title = title;
            this.path = path;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPath() {
            return path;
        }
    }
}
