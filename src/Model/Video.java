package Model;

import javax.swing.ImageIcon;

/**
 * Video class - Represents a video in the application.
 * Extends MediaItems and includes a preview icon for video representation.
 *
 * @author myMemo Team
 * @version 1.0
 */
public class Video extends MediaItems {
    /** Preview icon representing the video */
    private ImageIcon previewIcon;

    /**
     * Constructs a Video with title and preview icon.
     *
     * @param title The title of the video
     * @param previewIcon The ImageIcon representing the video preview
     */
    public Video(String title, ImageIcon previewIcon) {
        this.title = title;
        this.previewIcon = previewIcon;
        this.selected = false;
    }

    /**
     * Gets the preview icon of the video.
     *
     * @return The preview ImageIcon
     */
    public ImageIcon getPreviewIcon() {
        return previewIcon;
    }
}
