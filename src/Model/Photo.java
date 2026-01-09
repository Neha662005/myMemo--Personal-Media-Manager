package Model;

import javax.swing.ImageIcon;

public class Photo extends MediaItems{
    private String title;
    private ImageIcon thumbnail;

    //constructor
    public Photo(String title, ImageIcon thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.selected = false;
    }

    //Getter methods
    public String getTitle() {
        return title;
    }

    public ImageIcon getThumbnail() {
        return thumbnail;
    }
}
