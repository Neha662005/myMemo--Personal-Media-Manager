package Model;

/**
 * MediaItems class - Abstract base class for all media items (photos, videos, etc).
 * Defines common properties and behavior for all media types in the application.
 *
 * @author myMemo Team
 * @version 1.0
 */
public abstract class MediaItems {
    /** Title or name of the media item */
    protected String title;
    /** Selection status of the media item */
    protected boolean selected;

    /**
     * Gets the title of the media item.
     *
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Checks if the media item is selected.
     *
     * @return true if selected, false otherwise
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * Sets the selection status of the media item.
     *
     * @param selected The selection status to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}

