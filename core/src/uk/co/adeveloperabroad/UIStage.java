package uk.co.adeveloperabroad;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.components.additional.ButtonComponent;
import com.uwsoft.editor.renderer.data.CompositeItemVO;
import com.uwsoft.editor.renderer.data.ProjectInfoVO;
import com.uwsoft.editor.renderer.scene2d.CompositeActor;
import com.uwsoft.editor.renderer.utils.ItemWrapper;
import com.uwsoft.editor.renderer.resources.IResourceRetriever;

public class UIStage extends Stage {

    private SceneLoader sceneLoader;


    public UIStage(Viewport viewport) {
        Gdx.input.setInputProcessor(this);

        sceneLoader = new SceneLoader();
        sceneLoader.loadScene("UIStage", viewport);
        IResourceRetriever ir = sceneLoader.getRm();


//        ItemWrapper root = new ItemWrapper(sceneLoader.getRoot());
//        CompositeItemVO leftButton = root.getChild("leftButton").getEntity().getComponents();

        ProjectInfoVO projectInfo = ir.getProjectVO();
        CompositeItemVO leftButton = projectInfo.libraryItems.get("leftButton");
        System.out.println(leftButton.toString());
        CompositeActor buttonActor = new CompositeActor(leftButton, ir);

        addActor(buttonActor);

        buttonActor.setX(getWidth() - buttonActor.getWidth());
        buttonActor.setY(getHeight() - buttonActor.getHeight());

        buttonActor.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Hi");
            }
        });
    }

    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public void act(float delta) {

       // sceneLoader.getEngine().update(delta);
        super.act(delta);
    }

}
