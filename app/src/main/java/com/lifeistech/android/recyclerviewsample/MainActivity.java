package com.lifeistech.android.recyclerviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
//    private RecyclerView.Adapter mAdapter;
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
        final List<String> itemNames = new ArrayList<String>(Arrays.asList(names));
        final List<Integer> itemImages = new ArrayList<Integer>(Arrays.asList(photos));

        final List<String> itemEmails = new ArrayList<String>();
        for(int i = 0; i < itemNames.size(); i++ ){
            String str = String.format(Locale.US, "%s@gmail.com", itemNames.get(i));
            itemEmails.add(str);
        }

        // specify an adapter (see also next example)
        final RecyclerView.Adapter mAdapter = new MyAdapter(itemImages, itemNames, itemEmails);
        mRecyclerView.setAdapter(mAdapter);

        // ItemTouchHelper
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP|ItemTouchHelper.DOWN, ItemTouchHelper.RIGHT) {

                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        final int fromPos = viewHolder.getAdapterPosition();
                        final int toPos = target.getAdapterPosition();
                        mAdapter.notifyItemMoved(fromPos,toPos);

                        return true;
                    }

                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                        final int fromPos = viewHolder.getAdapterPosition();
                        itemImages.remove(fromPos);
                        itemNames.remove(fromPos);
                        itemEmails.remove(fromPos);

                        mAdapter.notifyItemRemoved(fromPos);
                    }
                });

        itemTouchHelper.attachToRecyclerView(mRecyclerView);


//        for(int i = 0; i < myDataset.length; i++) {
//            myDataset[i] = "Data_0" + String.valueOf(i);
//        }

        // specify an adapter (see also next example)
//        mAdapter = new MyAdapter(myDataset);
//        mRecyclerView.setAdapter(mAdapter);

    }


}
