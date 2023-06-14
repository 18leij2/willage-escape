package com.example.willageescape;

import android.content.Context;
import android.widget.ImageView;
abstract class Tile {
    private ImageView tile;
    private Context context;
    private int x;
    private int y;
    public Tile(int resource, Context context) {
        this.tile = new ImageView(context);
        tile.setImageResource(resource);
    }

    public ImageView getTile() {
        return tile;
    }
}
