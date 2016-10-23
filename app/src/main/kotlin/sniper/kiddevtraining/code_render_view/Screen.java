package sniper.kiddevtraining.code_render_view;

import sniper.kiddevtraining.code_render_view.game_interfaces.Game;

/**
 * Created by sniper on 7/10/14.
 */
public abstract class Screen {
    protected final Game game;

    public Screen(Game game) {
        this.game = game;
    }

    public abstract void update(float deltaTime);

    public abstract void paint(float deltaTime);

    public abstract void pause();

    public abstract void resume();

    public abstract void dispose();

    public abstract void backButton();
}