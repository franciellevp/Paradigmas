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
        System.out.println(raindrop.getX() +  ' ' + raindrop.getY());
    }

    public void setHeight(float h) {
        raindrop.height = h;
    }

    /*public Texture getTexture(float h) {
        return raindrop.texture;
    }*/

    public void setWidth(float w) {
        raindrop.width = w;
    }

    public float getHeight(float h) {
        return raindrop.height;
    }

    public float getWidth(float w) {
        return raindrop.width;
    }

    public void setY(float y) {
        raindrop.y = y;
    }

    public void setX(float x) {
        raindrop.x = x;
    }

    public void updatePosDrop(){
        raindrop.x = getX();
        raindrop.y = getY();
    }

    public boolean overlaps(Rectangle rect){
        return raindrop.overlaps(rect);
    }
}