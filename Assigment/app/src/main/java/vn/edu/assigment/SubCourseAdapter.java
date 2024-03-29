package vn.edu.assigment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SubCourseAdapter extends RecyclerView.Adapter<SubHolder> {
    private Context context;
    public List<Couser> couserList;
    public AppDataBase appDataBase;

    public SubCourseAdapter(Context context, List<Couser> couserList, AppDataBase appDataBase) {
        this.context = context;
        this.couserList = couserList;
        this.appDataBase = appDataBase;
    }

    @NonNull
    @Override
    public SubHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.subcourse, parent, false);
        SubHolder subHolder = new SubHolder(view);
        return subHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SubHolder holder, final int position) {
        final Couser couser = couserList.get(position);
        holder.edtSubname.setText(couser.name);
        holder.edtSubprice.setText(couser.price+"");
        holder.imgDeleteInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appDataBase.courseDao().delete(couser);
                couserList.remove(position);
                notifyDataSetChanged();
                Toast.makeText(context,"Hủy khóa học thành công",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return couserList.size();
    }
}
