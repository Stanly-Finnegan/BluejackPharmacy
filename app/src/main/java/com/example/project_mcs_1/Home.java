package com.example.project_mcs_1;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Home extends Fragment {


    RecyclerView recyclerView;
    GridAdapterRecyclerView gridAdapterRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<MedicineModel> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView_home);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);

        data = new ArrayList<>();
        for (int i=0 ; i<MedicineData.nama.length; i++){
            data.add(new MedicineModel(
                    MedicineData.nama[i],
                    MedicineData.manufaktur[i],
                    MedicineData.tipe[i],
                    MedicineData.harga[i],
                    MedicineData.gambar[i],
                    MedicineData.detail[i]
            ));

        }




        gridAdapterRecyclerView = new GridAdapterRecyclerView(data);
        recyclerView.setAdapter(gridAdapterRecyclerView);


        gridAdapterRecyclerView.setOnItemClickCallBack(new GridAdapterRecyclerView.OnItemClickCallBack() {
            @Override
            public void onItemClicked(MedicineModel data) {
                Intent myIntent = new Intent(getActivity(),DetailActivity.class);
                myIntent.putExtra("xNamaObat",data.getNama());
                myIntent.putExtra("xManufObat",data.getManufaktur());
                myIntent.putExtra("xGambarObat",data.getGambar());
                myIntent.putExtra("xHargaObat",data.getHarga());
                myIntent.putExtra("xDetailObat",data.getDetail());
                myIntent.putExtra("xTipeObat",data.getTipe());


                startActivity(myIntent);
            }
        });


        // Inflate the layout for this fragment
        return view;
    }


}