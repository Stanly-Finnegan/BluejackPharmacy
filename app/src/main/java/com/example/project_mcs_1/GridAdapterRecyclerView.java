package com.example.project_mcs_1;

import android.content.Intent;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GridAdapterRecyclerView extends RecyclerView.Adapter<GridAdapterRecyclerView.ViewHolder> {



    private ArrayList<MedicineModel> medicinedata;

    public GridAdapterRecyclerView(ArrayList<MedicineModel> medicinedata) {
        this.medicinedata = medicinedata;

    }

    public interface OnItemClickCallBack{
        void onItemClicked(MedicineModel data);
    }

    private OnItemClickCallBack callback;

    public void setOnItemClickCallBack(OnItemClickCallBack callback) {
        this.callback = callback;
    }

    @NonNull
    @Override
    public GridAdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_model, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridAdapterRecyclerView.ViewHolder holder, int position) {
        MedicineModel medicine = medicinedata.get(position);

        holder.nama.setText(medicine.getNama());
        holder.manufaktur.setText(medicine.getManufaktur());
        holder.tipe.setText(medicine.getTipe());
        holder.harga.setText(medicine.getHarga());
        holder.img.setImageResource(medicine.getGambar());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onItemClicked(medicinedata.get(holder.getAdapterPosition()));
            }
        });



    }

    @Override
    public int getItemCount() {
        return medicinedata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView nama, manufaktur, tipe, harga, detail;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_obat);
            nama = itemView.findViewById(R.id.nama_obat);
            manufaktur = itemView.findViewById(R.id.manuf_obat);
            tipe = itemView.findViewById(R.id.tipe_obat);
            harga = itemView.findViewById(R.id.harga_obat);
            detail = itemView.findViewById(R.id.deskripsi_detail);



        }
    }


}
