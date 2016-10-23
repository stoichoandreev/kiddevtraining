package sniper.kiddevtraining;

import android.support.annotation.AnimRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by sniper on 10/15/16.
 */

public abstract class AdapterDelegate <T> {

    protected final static int DEFAULT_ANIMATION = R.anim.slide_in_bottom;
    protected final static int FADE_IN_CENTER_ANIMATION = R.anim.fade_in_center;
    protected final static int SLIDE_WITH_ROTATE_ANIMATION = R.anim.slide_in_with_rotate;
    protected final static int WITHOUT_ANIMATION = -1;

    private int lastPosition;//use this to not repeat animation when user scroll up and down
    /**
     * Creates the  {@link RecyclerView.ViewHolder}
     *
     * @param parent The ViewGroup parent of the given data source
     * @param viewType represent the view type if we have more then one view types in this adapter
     * @return The new instantiated {@link RecyclerView.ViewHolder}
     */
    @NonNull
    public abstract RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType );
    /**
     * Here you must set your animation resource if you want animation. Otherwise return -1
     */
    @AnimRes
    public abstract int getAnimationResource();

    /**
     * Called to bind the {@link RecyclerView.ViewHolder} to the given module data item
     *
     * @param holder The {@link RecyclerView.ViewHolder} to bind
     * @param module The module object that contains the data to be bound
     */
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, T module, int position){
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, T module, int position, View.OnClickListener listener){
        setAnimation(holder.itemView,position);
    }

    protected void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition && getAnimationResource() != -1) {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), getAnimationResource());
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    /**
     * Clear starting animation if exist to help on recycler view to draw easy
     * @param holder - holder to access it's root view and stop it animation
     */
    public void clearAnimation(RecyclerView.ViewHolder holder) {
        holder.itemView.clearAnimation();
    }
}
