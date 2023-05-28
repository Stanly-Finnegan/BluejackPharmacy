package com.example.project_mcs_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class DetailActivity extends AppCompatActivity {

    private ImageView gambar,logout,backbtn, info;
    private TextView nama,manufaktur,harga, detail, tipe;

    private String yNama, yManufObat, yHargaObat, yDetailObat, yTipe,Quantity,finalHarga;

    private int yGambarObat, int_harga, int_qty;


   EditText quantity;
   Button btn_buy;

   static ArrayList<TransactionModel> Tdata = new ArrayList<>();;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        quantity = findViewById(R.id.quantity_edittext_detail);
        logout = findViewById(R.id.logout_detail);
        backbtn = findViewById(R.id.back_btn_detail);
        info = findViewById(R.id.info_detail);
        btn_buy = findViewById(R.id.btn_buy);


        initView();


        Intent myIntent = getIntent();
        yNama = myIntent.getStringExtra("xNamaObat");
        yManufObat = myIntent.getStringExtra("xManufObat");
        yGambarObat = myIntent.getIntExtra("xGambarObat",0);
        yHargaObat = myIntent.getStringExtra("xHargaObat");
        yDetailObat = myIntent.getStringExtra("xDetailObat");
        yTipe = myIntent.getStringExtra("xTipeObat");

        nama.setText(yNama);
        manufaktur.setText(yManufObat);
        harga.setText(yHargaObat);
        gambar.setImageResource(yGambarObat);
        detail.setText(yDetailObat);
        tipe.setText((yTipe));

        Quantity = quantity.getText().toString();



//        hargaobatint = (Integer.parseInt(yHargaObat))*(Integer.parseInt(Quantity));
//        finalHarga = String.valueOf(hargaobatint);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(),LoginActivity.class);
                startActivity(myIntent);
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(),AboutusActivity.class);
                startActivity(myIntent);
            }
        });

        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(TextUtils.isEmpty(quantity.getText().toString())){
                    Toast.makeText(DetailActivity.this, "Must be Field", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(Integer.parseInt(quantity.getText().toString()) < 1){
                    Toast.makeText(DetailActivity.this, "Minumum Order 1", Toast.LENGTH_SHORT).show();
                    return;

                }
                else {
                    Intent myIntent = new Intent(getBaseContext(),HomeActivity.class);
                    myIntent.putExtra("bottomnavpage", 1);
                    startActivity(myIntent);

                }

                int_harga = Integer.parseInt(yHargaObat);
                int_qty = Integer.parseInt(quantity.getText().toString());

                finalHarga = String.valueOf(int_harga*int_qty);


                Log.i("testing","ini "+Integer.parseInt(quantity.getText().toString()));


                DateFormat date = new SimpleDateFormat("dd/mm/yy - hh:mm");
                Calendar calendar = Calendar.getInstance();
                calendar.getTime();

                Tdata.add(new TransactionModel(yNama,yManufObat,quantity.getText().toString(),yGambarObat,finalHarga, date.format(calendar.getTime())));
//                Log.i("checkDetail","data:" +yNama);
//                Transaction transaction = new Transaction();
//                Bundle bundle = new Bundle();
//              bundle.putSerializable("Arraylist", Tdata);
//                bundle.putParcelableArrayList("Arraylist", Tdata);
//                transaction.setArguments(bundle);
//                startActivity(myIntent);



            }
        });







    }

    private void initView(){
        nama = findViewById(R.id.nama_obat_detail);
        manufaktur = findViewById(R.id.manuf_obat_detail);
        gambar = findViewById(R.id.img_obat_detail);
        harga = findViewById(R.id.harga_obat_detail);
        detail = findViewById(R.id.deskripsi_detail);
        tipe = findViewById(R.id.tipe_obat_detail);

    }



}