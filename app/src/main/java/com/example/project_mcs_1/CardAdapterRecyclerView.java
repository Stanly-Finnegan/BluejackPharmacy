package com.example.project_mcs_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardAdapterRecyclerView extends RecyclerView.Adapter<CardAdapterRecyclerView.ViewHolder> {

    private ArrayList<MedicineModel> medicinedata;

    private ArrayList<TransactionModel> transactiondata;

    public CardAdapterRecyclerView(ArrayList<TransactionModel> transactiondata) {
        this.transactiondata = transactiondata;
    }

//    public CardAdapterRecyclerView(ArrayList<MedicineModel> medicinedata) {
//        this.medicinedata = medicinedata;
//    }

    @NonNull
    @Override
    public CardAdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_model, parent, false);

        return new CardAdapterRecyclerView.ViewHolder(view);
    }

//    @Override
//    public void onBindViewHolder(@NonNull CardAdapterRecyclerView.ViewHolder holder, int position) {
//        MedicineModel medicine = medicinedata.get(position);
//
//        holder.nama.setText(medicine.getNama());
//        holder.manufaktur.setText(medicine.getManufaktur());
//        holder.harga.setText(medicine.getHarga());
//        holder.img.setImageResource(medicine.getGambar());
//    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapterRecyclerView.ViewHolder holder, int position) {
        TransactionModel transactionModel = transactiondata.get(position);

        holder.nama.setText(transactionModel.getNama());
        holder.harga.setText(transactionModel.getHarga());
        holder.img.setImageResource(transactionModel.getGambar());
        holder.qty.setText(transactionModel.getQty());
        holder.manufaktur.setText(transactionModel.getManuf());
        holder.tanggal.setText((transactionModel.getTanggal()));
    }

//    @Override
//    public int getItemCount() {
//        return medicinedata.size();
//    }
    @Override
    public int getItemCount() {
        return transactiondata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView nama, manufaktur, harga, tanggal;

        TextView qty;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_obat_card);
            nama = itemView.findViewById(R.id.nama_obat_card);
            manufaktur = itemView.findViewById(R.id.manuf_obat_card);
            harga = itemView.findViewById(R.id.harga_obat_card);
            qty = itemView.findViewById(R.id.quantity_card);
            tanggal = itemView.findViewById(R.id.tanggal_card);

        }
    }
}
