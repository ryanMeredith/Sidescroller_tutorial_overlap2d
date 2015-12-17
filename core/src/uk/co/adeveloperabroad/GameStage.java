package uk.co.adeveloperabroad;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.resources.IResourceRetriever;
import com.uwsoft.editor.renderer.utils.ItemWrapper;

public class GameStage extends Stage {

    private SceneLoader sceneLoader;
    private Viewport viewport;
    private PlayerController pc;


    public GameStage(Viewport viewport) {
        this.viewport = viewport;
        sceneLoader = new SceneLoader();
        sceneLoader.loadScene("MainScene", viewport);
        ItemWrapper root = new ItemWrapper(sceneLoader.getRoot());
        pc = new PlayerController();
        root.getChild("player").addScript(pc);
    }

    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public void act(float delta) {

        sceneLoader.getEngine().update(delta);
        super.act(delta);
        viewport.getCamera().position.x = pc.getX() + 100f;
        viewport.getCamera().position.y =  viewport.getWorldHeight() * 0.5f + pc.getY() - pc.getHeight() * 0.5f;
    }
}
