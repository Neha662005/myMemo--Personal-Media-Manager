package Model;

import javax.swing.ImageIcon;

public class Photo {
    private String title;
    private ImageIcon thumbnail;

    public Photo(String title, ImageIcon thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public ImageIcon getThumbnail() {
        return thumbnail;
    }
}
