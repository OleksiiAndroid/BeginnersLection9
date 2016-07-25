package ua.com.webacademy.beginnerslection9;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    private ArrayList<Student> mStudents;
    private LayoutInflater mInflater;

    private OnItemClickListener Listener;

    public RecyclerAdapter(android.content.Context context, ArrayList<Student> students) {
        this.mStudents = students;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.child_item, null);

        StudentViewHolder viewHolder = new StudentViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StudentViewHolder studentViewHolder, final int i) {
        Student student = mStudents.get(i);

        studentViewHolder.mTextViewFirstName.setText(student.FirstName);
        studentViewHolder.mTextViewLastName.setText(student.LastName);
        studentViewHolder.mTextViewAge.setText(String.valueOf(student.Age));

        studentViewHolder.mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Listener != null) {
                    Listener.onItemClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStudents.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.Listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
