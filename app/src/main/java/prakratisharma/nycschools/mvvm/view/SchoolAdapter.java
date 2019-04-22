package prakratisharma.nycschools.mvvm.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import prakratisharma.nycschools.mvvm.R;
import prakratisharma.nycschools.mvvm.model.SchoolDetails;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.SchoolViewHolder>
{
    Context mCtx;
    List<SchoolDetails> schoolDetailsList;
    private View.OnClickListener listener;
    public SchoolAdapter(Context mCtx, List<SchoolDetails> schoolDetailsList) {
        this.mCtx = mCtx;
        this.schoolDetailsList = schoolDetailsList;
    }
    public void setSchoolList(List<SchoolDetails> schoolDetailsList) {
        this.schoolDetailsList = schoolDetailsList;
        notifyDataSetChanged();
    }

    public void setClickListener(View.OnClickListener callback) {
        listener = callback;
    }
    @NonNull
    @Override
    public SchoolViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.school_item, parent, false);
        SchoolViewHolder holder = new SchoolViewHolder(v);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(view);

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolViewHolder schoolViewHolder, int position) {
        SchoolDetails schoolDetails = schoolDetailsList.get(position);
        schoolViewHolder.schoolNameTV.setText(schoolDetails.getName());

        schoolViewHolder.itemView.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return schoolDetailsList!=null ? schoolDetailsList.size() :0;
    }

    public class SchoolViewHolder extends RecyclerView.ViewHolder {
        private TextView schoolNameTV;
        public SchoolViewHolder(View itemView) {
            super(itemView);

            schoolNameTV = itemView.findViewById(R.id.school_name);
        }
    }
}