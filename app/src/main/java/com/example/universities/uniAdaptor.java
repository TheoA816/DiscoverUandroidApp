package com.example.universities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;


public class uniAdaptor extends RecyclerView.Adapter<uniAdaptor.ViewHolder> {

    private ArrayList<university> uniArray;
    private Context context;
    private String parentActivity;

    public uniAdaptor(Context context, String parentActivity) {
        this.context = context;
        this.parentActivity = parentActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.uni_view, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.cityname.setText(uniArray.get(position).getCity());
        holder.rank.setText(Integer.toString(uniArray.get(position).getQSworldRank()));
        holder.uniname.setText(uniArray.get(position).getUniName());

        if(parentActivity.equals("favorites")){
            holder.remove.setVisibility(View.VISIBLE);
            holder.remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Are you sure?");
                    builder.setPositiveButton("Remove", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            utils.getInstance().removeFromFavorites(uniArray.get(position));
                            notifyDataSetChanged();
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    builder.create().show();
                }
            });
        }

        Glide.with(context)
                .asBitmap()
                .load(uniArray.get(position).getUniPhoto())
                .into(holder.uniphoto);

        holder.uniview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, IndividualUni.class);
                intent.putExtra("country", uniArray.get(position).getCity());
                intent.putExtra("rank", uniArray.get(position).getQSworldRank());
                intent.putExtra("initial", uniArray.get(position).getInitial());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return uniArray.size();
    }

    public void setUniArray(ArrayList<university> uniArray) {
        this.uniArray = uniArray;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private MaterialCardView uniview;
        private TextView rank, qsworldrank, city, cityname, uniname, remove;
        private ImageView uniphoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rank=itemView.findViewById(R.id.rank);
            qsworldrank=itemView.findViewById(R.id.QSworldRank);
            city=itemView.findViewById(R.id.city);
            cityname=itemView.findViewById(R.id.cityname);
            uniname=itemView.findViewById(R.id.uniName);
            uniview=itemView.findViewById(R.id.uniview);
            uniphoto=itemView.findViewById(R.id.uniphoto);
            remove=itemView.findViewById(R.id.remove);
        }
    }
}
