package com.example.project_mcs_1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class Transaction extends Fragment {

    RecyclerView recyclerView;
    CardAdapterRecyclerView cardAdapterRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<MedicineModel> data;

    ArrayList<TransactionModel> Tdata = DetailActivity.Tdata;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_transaction, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView_transaction);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);



//            Tdata = this.getArguments().getParcelableArrayList("Arraylist");
            Log.i("checkTransaction","data:" +Tdata.get(0).nama);







//        data = new ArrayList<>();
//        for (int i=0 ; i<MedicineData.nama.length; i++){
//            data.add(new MedicineModel(
//                    MedicineData.nama[i],
//                    MedicineData.manufaktur[i],
//                    MedicineData.tipe[i],
//                    MedicineData.harga[i],
//                    MedicineData.gambar[i],
//                    MedicineData.detail[i]
//            ));

//        }



        cardAdapterRecyclerView = new CardAdapterRecyclerView(Tdata);
        recyclerView.setAdapter(cardAdapterRecyclerView);

        return view;
    }
}