package work.vuong.oktober.realm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.TextView;

import io.realm.OrderedRealmCollection;
import io.realm.RealmModel;
import io.realm.RealmRecyclerViewAdapter;

/**
 * Created by oberon (vuongpham) on 25/10/2016.
 *
 * Stupid adapter that takes any object
 */
class TextAdapter<T extends RealmModel> extends RealmRecyclerViewAdapter<T, TextViewHolder> {

    public TextAdapter(@NonNull Context context, @Nullable OrderedRealmCollection<T> data, boolean autoUpdate) {
        super(context, data, autoUpdate);
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TextViewHolder(new TextView(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {
        T item = getItem(position);
        if (item == null) return;
        holder.getTextView().setText(item.toString());
    }
}
