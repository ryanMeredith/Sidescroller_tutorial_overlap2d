package uk.co.adeveloperabroad;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class PlatformerTutorial extends ApplicationAdapter {


    private GameStage gameStage;
	private UIStage uiStage;

	
	@Override
	public void create () {
		FitViewport viewport = new FitViewport(267, 160);
        gameStage = new GameStage(viewport);

		FitViewport uiViewport = new FitViewport(267, 160);
		uiStage = new UIStage(uiViewport);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameStage.act(Gdx.graphics.getDeltaTime());
        gameStage.draw();
		uiStage.act(Gdx.graphics.getDeltaTime());
		uiStage.draw();
	}
}
