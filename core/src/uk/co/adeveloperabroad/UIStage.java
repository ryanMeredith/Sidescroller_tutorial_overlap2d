package uk.co.adeveloperabroad;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.components.additional.ButtonComponent;
import com.uwsoft.editor.renderer.data.CompositeItemVO;
import com.uwsoft.editor.renderer.data.ProjectInfoVO;
import com.uwsoft.editor.renderer.scene2d.ButtonClickListener;
import com.uwsoft.editor.renderer.scene2d.CompositeActor;
import com.uwsoft.editor.renderer.utils.ItemWrapper;

public class UIStage extends Stage {

    SceneLoader sceneLoader;

    public UIStage(Viewport uiViewport) {

        sceneLoader = new SceneLoader();
        sceneLoader.loadScene("UIStage", uiViewport);
        buttonOneListener(sceneLoader);
        libraryButtonListener(sceneLoader);
        libraryButtonActor(sceneLoader);


    }

    // get button that is
    protected void buttonOneListener(SceneLoader sceneLoader){
        ItemWrapper root = new ItemWrapper(sceneLoader.getRoot());

        Entity rightButton = root.getChild("rightButton").getEntity();

        ButtonComponent buttonComponent = new ButtonComponent();
        buttonComponent.addListener(new ButtonComponent.ButtonListener() {
            @Override
            public void touchUp() {

            }

            @Override
            public void touchDown() {

            }

            @Override
            public void clicked() {
                System.out.println("I'm button one");
            }
        });

        rightButton.add(buttonComponent);
    }

    protected void libraryButtonListener(SceneLoader sceneLoader) {
        CompositeItemVO libraryButtonData =  sceneLoader.loadVoFromLibrary("libraryButton");
        libraryButtonData.x = 150;
        libraryButtonData.y = 25;
        Entity libraryUI = sceneLoader.entityFactory.createEntity(sceneLoader.getRoot(), libraryButtonData);
        sceneLoader.entityFactory.initAllChildren(sceneLoader.getEngine(), libraryUI, libraryButtonData.composite);
        sceneLoader.getEngine().addEntity(libraryUI);

        ItemWrapper root = new ItemWrapper(sceneLoader.getRoot());

        Entity libraryButton = root.getChild("libraryUi").getChild("libraryButton").getEntity();
        ButtonComponent buttonComponent = new ButtonComponent();
        buttonComponent.addListener(new ButtonComponent.ButtonListener() {
            @Override
            public void touchUp() {

            }

            @Override
            public void touchDown() {

            }

            @Override
            public void clicked() {
                System.out.println("I'm a library Entity Button");
            }
        });

        libraryButton.add(buttonComponent);

    }

    protected void libraryButtonActor(SceneLoader sceneLoader) {
        ProjectInfoVO projectInfoVO = sceneLoader.getRm().getProjectVO();
        CompositeItemVO wheelButtonItem = projectInfoVO.libraryItems.get("wheelButton");
        System.out.println(wheelButtonItem);
        CompositeActor wheelButton = new CompositeActor(wheelButtonItem, sceneLoader.getRm());
        addActor(wheelButton);
        wheelButton.setX(getWidth() - wheelButton.getWidth());
        wheelButton.setY(0 + wheelButton.getHeight());
        wheelButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                System.out.println("I'm a library actor Button");
            }
        });
    }

    @Override
    public void act() {
        super.act();
    }

    @Override
    public void draw() {
        super.draw();
        sceneLoader.getEngine().update(Gdx.graphics.getDeltaTime());
    }

}
