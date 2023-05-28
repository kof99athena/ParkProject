package com.nha1400.project02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nha1400.project02.R;
import com.nha1400.project02.model.ParkInfo;

import java.util.ArrayList;

public class ParkAdapter extends RecyclerView.Adapter<ParkAdapter.VH> {
    Context context;
    ArrayList<ParkInfo> parkInfos;


    public ParkAdapter(Context context, ArrayList<ParkInfo> parkInfos) {
        this.context = context;
        this.parkInfos = parkInfos;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(context).inflate(R.layout.container_api, parent, false);
        return new VH(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        ParkInfo info = parkInfos.get(position);
        holder.name.setText(info.name);
        holder.addr.setText(info.addr);
        Glide.with(context)
                .load(info.image)
                .error(R.drawable.tobiwa)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return parkInfos.size();
    }


    class VH extends RecyclerView.ViewHolder {

        TextView name, addr;
        ImageView pic;

        public VH(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.cardview_name);
            addr = itemView.findViewById(R.id.cardview_addr);
            pic = itemView.findViewById(R.id.cardview_pic);
        }
    }

}
