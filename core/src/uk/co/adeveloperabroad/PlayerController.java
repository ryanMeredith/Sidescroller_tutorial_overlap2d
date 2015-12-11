package uk.co.adeveloperabroad;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.uwsoft.editor.renderer.components.DimensionsComponent;
import com.uwsoft.editor.renderer.components.TransformComponent;
import com.uwsoft.editor.renderer.components.sprite.AnimationComponent;
import com.uwsoft.editor.renderer.components.sprite.SpriteAnimationStateComponent;
import com.uwsoft.editor.renderer.scripts.IScript;

public class PlayerController implements IScript {

    private Entity player;
    private TransformComponent transformComponent;
    private DimensionsComponent dimensionsComponent;
    private SpriteAnimationStateComponent spriteAnimationStateComponent;
    private Boolean isWalking = false;
    private Vector2 speed;
    private float gravity =  -100.0f;
    private float jumpSpeed = 400.0f;

    @Override
    public void init(Entity entity) {
        player = entity;
        for (Component component:  player.getComponents()) {
            System.out.println(component.toString());
        }

        transformComponent = entity.getComponent(TransformComponent.class);
        dimensionsComponent = entity.getComponent(DimensionsComponent.class);
        spriteAnimationStateComponent = entity.getComponent(SpriteAnimationStateComponent.class);
        speed = new Vector2(100, 0);
    }

    @Override
    public void act(float delta) {

        isWalking = false;

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            transformComponent.x -= speed.x * delta;
            transformComponent.scaleX = -1f;
            isWalking = true;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            transformComponent.x += speed.x * delta;
            transformComponent.scaleX = 1f;
            isWalking = true;
        }


        spriteAnimationStateComponent.paused = !isWalking;


        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            speed.y += jumpSpeed * delta;
        }

        speed.y += gravity * delta; ;
        transformComponent.y = speed.y;

        if (transformComponent.y < 5f ){
            speed.y = 0;
            transformComponent.y = 5f;
        }
    }

    public float getX() {
        return transformComponent.x;
    }

    public float getY() {
        return transformComponent.y;
    }

    public float getHeight() {
        return dimensionsComponent.height;
    }


    @Override
    public void dispose() {

    }
}
