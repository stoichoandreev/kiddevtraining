package sniper.kiddevtraining;

import android.app.Fragment;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntegerRes;
import android.support.annotation.StringRes;
import android.support.annotation.UiThread;
import android.support.v4.content.ContextCompat;

/**
 * Created by sniper on 9/09/15.
 * This Fragment is same like BaseSupportFragment but it is for all Fragments which aren't Support Fragments
 */
@UiThread
public abstract class BaseFragment extends Fragment {

//    protected BaseActivity mActivity;
//    protected BasePresenter mPresenter;//every view(Fragment) need its own presenter

    @CallSuper
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mActivity = (BaseActivity) getActivity();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @CallSuper
    @Override
    public void onResume() {
        super.onResume();
//        inform all instances of this fragment about language change
//        setFragmentTexts(mActivity.isLanguageChange());
//        if(mPresenter != null) {
//            mPresenter.bindView(this);
//        }
//        mActivity.connectivityChange(RequestRetry.getInstance().isConnected());
        //call this code to hide keyboard if it is open from previous fragment
//        mActivity.hideSoftKeyBoard(getView());
    }
    @Override
    public void onPause() {
        super.onPause();
//        if(mPresenter != null) {
//            mPresenter.unbindView();
//        }
    }
    @UiThread
    protected String getStringResourceSafety(@StringRes int stringResource){
        return isAdded() ? getResources().getString(stringResource) : "";
    }
    @UiThread
    protected int getIntResourceSafety(@IntegerRes int intResource){
        return isAdded() ? getResources().getInteger(intResource) : 0;
    }
    @UiThread
    protected int getColourResourceSafety(@ColorRes int colourResource){
        return isAdded() ? ContextCompat.getColor(getActivity(), colourResource) : 0;
    }
    @UiThread
    protected Drawable getDrawableResourceSafety(@DrawableRes int drawableResource){
        return isAdded() ? ContextCompat.getDrawable(getActivity(),drawableResource) : new Drawable() {
            @Override
            public void draw(Canvas canvas) {

            }

            @Override
            public void setAlpha(int alpha) {

            }

            @Override
            public void setColorFilter(ColorFilter colorFilter) {

            }

            @Override
            public int getOpacity() {
                return PixelFormat.OPAQUE;
            }
        };
    }

    public abstract void notifyFragmentAboutAction(FragmentAction fragmentAction);
}
