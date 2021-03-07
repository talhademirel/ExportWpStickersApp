package com.example.exportwpstickers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;


import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Sticker> arrayList;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();

       Toast.makeText(MainActivity.this,"HELLO WORLD!",Toast.LENGTH_LONG).show();
    }

    public void getStickers(){
        try {
            File stickerDirectory = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/myStickers");
            if (!stickerDirectory.exists()) {
                stickerDirectory.mkdir();
            }
            String PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/WhatsApp/Media/WhatsApp Stickers";
            File file = new File(PATH);
            File[] listFiles = file.listFiles();
            for (int i=0;i<500;i++){
                Bitmap bitmap = BitmapFactory.decodeFile(listFiles[i].getAbsolutePath());
                arrayList.add(new Sticker(bitmap));


                FileOutputStream out = new FileOutputStream(stickerDirectory.getAbsolutePath() + "/" + Integer.toString(i) + ".png");
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);


                Adapter myAdapter = new Adapter(this,arrayList);
                recyclerView.setLayoutManager(new GridLayoutManager(this,7));
                recyclerView.setAdapter(myAdapter);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void importData(View view){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)  != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }else{
            getStickers();
        }
        }
    }
