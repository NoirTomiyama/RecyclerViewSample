package com.lifeistech.android.recyclerviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

//    private String[] myDataset = new String[20];

    private static final String[] names = {
            "apple_1", "banana_2", "orange_3", "strawberry_4",
            "apple_5", "banana_6", "orange_7", "strawberry_8",
            "apple_9", "banana_10"
    };

    // ArrayListにコピーするためintからInteger型に
    private static final Integer[] photos = {
            R.drawable.apple_1, R.drawable.banana_2,
            R.drawable.orange_3, R.drawable.strawberry_4,
            R.drawable.apple_5, R.drawable.banana_6,
            R.drawable.orange_7, R.drawable.strawberry_8,
            R.drawable.apple_9, R.drawable.banana_10
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);  // RecyclerViewのサイズを維持し続ける

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);


        // 配列をArrayListにコピー
        List<String> itemNames = new ArrayList<String>(Arrays.asList(names));
        List<Integer> itemImages = new ArrayList<Integer>(Arrays.asList(photos));

        List<String> itemEmails = new ArrayList<String>();
        for(int i = 0; i < itemNames.size(); i++ ){
            String str = String.format(Locale.US, "%s@gmail.com", itemNames.get(i));
            itemEmails.add(str);
        }

        // specify an adapter (see also next example)
        RecyclerView.Adapter mAdapter = new MyAdapter(itemImages, itemNames, itemEmails);
        mRecyclerView.setAdapter(mAdapter);


//        for(int i = 0; i < myDataset.length; i++) {
//            myDataset[i] = "Data_0" + String.valueOf(i);
//        }

        // specify an adapter (see also next example)
//        mAdapter = new MyAdapter(myDataset);
//        mRecyclerView.setAdapter(mAdapter);

    }


}
