package org.csie.foop.qaq;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class CarcassonneGame extends ApplicationAdapter {
    SpriteBatch batch;
    OrthographicCamera camera;
    Texture [][] img;

    @Override
    public void create () {
        batch = new SpriteBatch();
        img = new Texture[25][25];
        for(int i=0; i<5; ++i)
            for(int j=0; j<5; ++j)
                img[i][j] = new Texture(String.format("img/card/card_%d_%d.bmp", i, j));
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()*2);
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0);
        camera.rotate(45);
        camera.update();
    }

    @Override
    public void render () {
        if(Gdx.input.isKeyJustPressed(Input.Keys.X)) {
            camera.rotate(90);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            camera.translate(0, 3, 0);
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            camera.translate(0, -3, 0);
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            camera.translate(-3, 0, 0);
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            camera.translate(3, 0, 0);
        }
        camera.update();
        Vector3 mousePosition = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        mousePosition = camera.unproject(mousePosition);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        int width = img[0][0].getWidth();
        int height = img[0][0].getHeight();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for(int i=0; i<5; ++i)
            for(int j=0; j<5; ++j) {
                if(i*width <= mousePosition.x && mousePosition.x <= (i+1)*width &&
                    j*height <= mousePosition.y && mousePosition.y <= (j+1)*height) {
                    batch.setColor(1, 1, 0, 1);
                    batch.draw(img[i][j], i * width, j * height);
                    batch.setColor(1, 1, 1, 1);
                }
                else {
                    batch.draw(img[i][j], i * width, j * height);
                }
            }
        batch.end();
    }
}
