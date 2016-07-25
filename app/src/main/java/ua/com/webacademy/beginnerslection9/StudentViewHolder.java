package ua.com.webacademy.beginnerslection9;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    public TextView mTextViewFirstName;
    public TextView mTextViewLastName;
    public TextView mTextViewAge;
    public View mRootView;

    public StudentViewHolder(View view) {
        super(view);

        mTextViewFirstName = (TextView) view.findViewById(R.id.firstName);
        mTextViewLastName = (TextView) view.findViewById(R.id.lastName);
        mTextViewAge = (TextView) view.findViewById(R.id.age);
        mRootView = view.findViewById(R.id.root);
    }
}
