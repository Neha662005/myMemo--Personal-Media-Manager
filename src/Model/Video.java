/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.swing.ImageIcon;
/**
 *
 * @author HP
 */
public class Video extends MediaItems {
    private ImageIcon previewIcon;

    public Video(String title, ImageIcon previewIcon) {
        this.title = title;
        this.previewIcon = previewIcon;
        this.selected = false;
    }

    public ImageIcon getPreviewIcon() {
        return previewIcon;
    }    
}
