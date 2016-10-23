package sniper.kiddevtraining;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CodeDelegate extends AdapterDelegate<CodeDataModel> {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new CodeLineViewHolder(inflater.inflate(R.layout.delegate_code_line_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, CodeDataModel module, int position) {
        CodeLineViewHolder codeLineViewHolder = (CodeLineViewHolder) holder;

        codeLineViewHolder.lineNumber.setText(Integer.toString(position + 1));
        codeLineViewHolder.codeLabel.setText(module.getCodeText());
        codeLineViewHolder.codeIcon.setImageResource(module.getCodeIcon());

        super.onBindViewHolder(holder,module,position);
    }

    @Override
    public int getAnimationResource() {
        return DEFAULT_ANIMATION;
    }

    class CodeLineViewHolder extends AdapterViewHolder {

        @BindView(R.id.code_line_parent_view)       FrameLayout itemParentView;
        @BindView(R.id.line_number)                 AppCompatTextView lineNumber;
        @BindView(R.id.code_label)                  AppCompatTextView codeLabel;
        @BindView(R.id.check_icon)                  ImageView codeIcon;

        public CodeLineViewHolder(View codeView) {
            super(codeView);
            ButterKnife.bind(this, codeView);
        }

        @Override
        public void clearAnimation() {
            itemParentView.clearAnimation();
        }
    }
}
