package sniper.kiddevtraining;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sniper on 10/15/16.
 */

public class CodeAdapter<T> extends RecyclerView.Adapter {

    protected AdapterDelegate<T> delegate;
    protected List<T> items;
    private DelegateType delegateType;

    public CodeAdapter(DelegateType type) {
        delegateType = type;
        items = new ArrayList<>();
        delegate = getDelegate();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return delegate.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final T module = items.get(position);
        delegate.onBindViewHolder(holder, module, position);
    }
    //On detach delegate from window this means that recyclerview is recycling and it going to reuse this delegate
    //So in this case we need to stop animation about detached delegate view
    @Override
    public void onViewDetachedFromWindow(final RecyclerView.ViewHolder holder) {
        delegate.clearAnimation(holder);
    }
    @Override
    public int getItemCount() {
        if (items == null || items.size() == 0) {
            return 0;
        }
        return items.size();
    }
    public void setItems(List<T> items, boolean needClean) {
        if(items == null) return;

        if(needClean) this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }
    public void addItem(T item) {
        if(items == null) return;
        this.items.add(item);
        notifyDataSetChanged();
    }
    public List<T> getAllItems(){
        return items;
    }

    public T getItem(int position){
        return (position >= items.size()) ?  null : items.get(position);
    }
    private AdapterDelegate getDelegate(){
        switch (delegateType){
            case TYPE_CODE:
                return new CodeDelegate();
            default:
                throw new RuntimeException("When you use this Generic Adapter, you need to provide type of the Adapter Delegate");
        }
    }
}

