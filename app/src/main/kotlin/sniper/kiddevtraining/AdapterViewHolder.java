package sniper.kiddevtraining;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by sniper on 5/22/16.
 */
public abstract class AdapterViewHolder extends RecyclerView.ViewHolder {

    public AdapterViewHolder(View itemView) {
        super(itemView);
    }
    public abstract void clearAnimation();
}
