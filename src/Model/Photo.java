package Model;

import javax.swing.ImageIcon;

/**
 * Photo class - Represents a photograph in the application.
 * Extends MediaItems and includes properties for photo metadata like size and file type.
 *
 * @author myMemo Team
 * @version 1.0
 */
public class Photo extends MediaItems {
    /** Title of the photo */
    private String title;
    /** Thumbnail image icon for preview */
    private ImageIcon thumbnail;
    /** Size of the photo file in bytes */
    private int size;
    /** File type/extension of the photo */
    private String fileType;
    /** File path to the photo */
    private String path;

    /**
     * Constructs a Photo with all properties.
     *
     * @param title The title of the photo
     * @param thumbnail The thumbnail ImageIcon for preview
     * @param size The file size in bytes
     * @param fileType The file type/extension (e.g., jpg, png)
     * @param path The file path to the photo
     */
    public Photo(String title, ImageIcon thumbnail, int size, String fileType, String path) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.selected = false;
        this.size = size;
        this.fileType = fileType;
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
     * Gets the size of the photo file.
     *
     * @return The size in bytes
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets the file type of the photo.
     *
     * @return The file type (e.g., jpg, png)
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * Gets the thumbnail image of the photo.
     *
     * @return The thumbnail ImageIcon
     */
    public ImageIcon getThumbnail() {
        return thumbnail;
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
