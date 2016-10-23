package sniper.kiddevtraining;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sniper on 2/10/16.
 */
public class CodeEditorFragment extends BaseFragment {

//    @BindView(R.id.about_fragment_mail)         PlacedCustomTextView aboutMail;
    @BindView(R.id.code_line_list)  RecyclerView codeRecyclerView;

    private CodeAdapter<CodeDataModel> codeAdapter;

    public static CodeEditorFragment newInstance(Bundle args) {
        CodeEditorFragment fragment = new CodeEditorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_code_editor, container, false);
        ButterKnife.bind(this, rootView);

        codeAdapter = new CodeAdapter(DelegateType.TYPE_CODE);
        assert codeRecyclerView != null;
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        codeRecyclerView.setLayoutManager(layoutManager);
        codeRecyclerView.setAdapter(codeAdapter);
//        mRecyclerView.addOnScrollListener(new PagerScrollListener());
        codeRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                onCodeLineSelected(view, position);
            }
        }));

        return rootView;
    }

    @Override
    public void notifyFragmentAboutAction(FragmentAction fragmentAction) {}

    private void onCodeLineSelected(View view, int position) {

    }
    public void setAdapterCodeItem(CodeDataModel code){
        codeAdapter.addItem(code);
    }
}
