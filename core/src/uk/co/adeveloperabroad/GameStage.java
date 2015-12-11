package uk.co.adeveloperabroad;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.utils.ItemWrapper;

public class GameStage extends Stage {

    private SceneLoader sl;
    private Viewport viewport;
    private PlayerController pc;


    public GameStage(Viewport viewport) {
        this.viewport = viewport;
        sl = new SceneLoader();
        sl.loadScene("MainScene", viewport);
        ItemWrapper root = new ItemWrapper(sl.getRoot());

        pc = new PlayerController();
        root.getChild("player").addScript(pc);
    }

    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public void act(float delta) {

        sl.getEngine().update(delta);
        super.act(delta);
        viewport.getCamera().position.x = pc.getX() + 100f;
        viewport.getCamera().position.y =  viewport.getWorldHeight() * 0.5f + pc.getY() - pc.getHeight() * 0.5f;
    }
}
