package Model;

import javax.swing.ImageIcon;

public class Photo {
    private String title;
    private ImageIcon thumbnail;

    //constructor
    public Photo(String title, ImageIcon thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }

    //Getter methods
    public String getTitle() {
        return title;
    }

    public ImageIcon getThumbnail() {
        return thumbnail;
    }
}
