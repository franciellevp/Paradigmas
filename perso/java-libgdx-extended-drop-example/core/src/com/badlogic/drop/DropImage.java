package com.badlogic.drop;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Texture;

public class DropImage extends Sprite{
    Rectangle raindrop = new Rectangle();

    public DropImage(Texture texture, int w, int h, float x, float y) {
        super(texture, w, h);
        raindrop.x = x;
        raindrop.y = y;
        raindrop.width = w;
        raindrop.height = h;
        setPosition(x, y);
    }

    public void updatePosDrop(){
        raindrop.x = getX();
        raindrop.y = getY();
    }

    public boolean overlaps(Rectangle rect){
        return raindrop.overlaps(rect);
    }
}