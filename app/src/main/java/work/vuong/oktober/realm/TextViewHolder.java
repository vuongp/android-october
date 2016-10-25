package work.vuong.oktober.realm;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

/**
 * Created by oberon (vuongpham) on 25/10/2016.
 */
public class TextViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;

    public TextViewHolder(TextView textView) {
        super(textView);
        this.textView = textView;
    }

    public TextView getTextView() {
        return textView;
    }
}
