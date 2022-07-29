package com.example.simplesurveycreator.activity;


import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplesurveycreator.R;

import java.util.ArrayList;

public class whatsappshare extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsappshare);
        Log.d(TAG, "onCreate: started");
        initImageBitmaps();
    }
    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: started");
        mImageUrls.add("https://img.pngio.com/laptop-cartoon-png-download-10061006-free-transparent-laptop-hp-laptop-png-900_900.jpg");
        mNames.add("hp Lap Users Grp");
        mImageUrls.add("https://static-ecapac.acer.com/media/catalog/product/cache/a17a77e026ef2eddd3ecae104c32cc71/m/a/magicpurple.jpg");
        mNames.add("Acer Lap Users Grp");
        mImageUrls.add("https://i.pinimg.com/originals/1b/d7/6d/1bd76dd709bdc1e840a410a443215ef0.jpg");
        mNames.add("Dell Lap Users Grp");
        mImageUrls.add("https://static.dribbble.com/users/3103355/screenshots/6994538/media/df155063edec4afd3a65a22d34dd7608.jpg");
        mNames.add("Leco Group");
        mImageUrls.add("https://www.userlogos.org/files/logos/robinhood/sliitlogob4.png");
        mNames.add("SLIIT_SE_Grp");
        mImageUrls.add("https://omigame.weebly.com/uploads/9/8/4/4/9844690/4607674.png");
        mNames.add("SLIIT_IT_Grp");
        mImageUrls.add("https://www.freepngimg.com/thumb/girls_generation/28267-2-snsd-free-download.png");
        mNames.add("Viska Set");
        mImageUrls.add("https://www.freeiconspng.com/uploads/survey-icon-12.png");
        mNames.add("Air Pollution Reduce Set");
        mImageUrls.add("https://www.clipartmax.com/png/middle/421-4213973_analysis-clipart-problem-identification-png-free-survey-icon.png");
        mNames.add("Online Classes 2020");
        mImageUrls.add("https://png.pngtree.com/png-clipart/20190120/ourmid/pngtree-personality-cartoon-boy-character-png-image_494536.jpg");
        mNames.add("Sasindu");
        mImageUrls.add("https://i.vippng.com/png/small/40-408120_girl-png-cb-edits-background-girl-png.png");
        mNames.add("Hashinthi");
        mImageUrls.add("https://www.clipartkey.com/mpngs/m/158-1580691_feedback-survey-icon-png.png");
        mNames.add("HR MAnagement Grp");
        mImageUrls.add("https://www.pngkit.com/png/full/57-577234_jumping-person-png-download-happy-girl-jumping-png.png");
        mNames.add("Vagisha");
        mImageUrls.add("https://i.dlpng.com/static/png/1348566-girl-png-hd-very-happy-girl-png-364_411_preview.png");
        mNames.add("Nimsara");
        mImageUrls.add("https://1.bp.blogspot.com/-HBmcJ90-eNk/WqKxBXzZxyI/AAAAAAAABgQ/cRwj4Eb7AsoGbzCLQQibmJfpX1z53XPiACLcBGAs/s1600/1520132921033.png");
        mNames.add("Dulanji");
        mImageUrls.add("https://toppng.com/uploads/preview/all-girls-png-full-hd-deepthi-sunaina-images-hd-115629889657zzjba0dft.png");
        mNames.add("Ajana");
        mImageUrls.add("https://www.pngonly.com/wp-content/uploads/2017/06/Happy-Person-Transparent-PNG-Image.png");
        mNames.add("Shakith");
        mImageUrls.add("https://i.dlpng.com/static/png/5489776-people-sitting-png-entourage-people-cutout-cut-out-persona-entourage-png-820_678_preview.png");
        mNames.add("Shalitha");
        mImageUrls.add("https://files.oyebesmartest.com/uploads/preview/-11570214057oax3u7p66r.png");
        mNames.add("Anesha");
        initRecyclerView();
    }
    private  void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: started");

        RecyclerView recyclerView = findViewById(R.id.recycler_view2);
        RecyclerViweAdapter2 adapter2 = new RecyclerViweAdapter2(mNames,mImageUrls,this);
        recyclerView.setAdapter(adapter2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
