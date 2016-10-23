package sniper.kiddevtraining;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sniper on 2/10/16.
 */
public class CodeSceneFragment extends BaseFragment {

    @BindView(R.id.code_apply_container) FrameLayout codeApplyContainer;

    private CodeLineListActivity mActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (CodeLineListActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_code_scene, container, false);
        ButterKnife.bind(this, rootView);

        codeApplyContainer.addView(mActivity.getRenderView());

        return rootView;
    }

    @Override
    public void notifyFragmentAboutAction(FragmentAction fragmentAction) {}

}
