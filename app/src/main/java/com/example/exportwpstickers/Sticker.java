package com.example.exportwpstickers;

import android.graphics.Bitmap;

public class Sticker {

    private Bitmap stickerImage;

    public Sticker(Bitmap stickerImage) {
        this.stickerImage = stickerImage;
    }

    public Bitmap getStickerImage() {
        return stickerImage;
    }

    public void setStickerImage(Bitmap stickerImage) {
        this.stickerImage = stickerImage;
    }
}
