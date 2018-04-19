package com.lifeistech.android.recyclerviewsample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

//    private String[] mDataset = new String[20];

    private List<Integer> iImages;
    private List<String> iNames;
    private List<String> iEmails;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

//        public TextView mTextView;

        // each data item is just a string in this case
        ImageView imageView;
        TextView textView;
        TextView emailView;


        public ViewHolder(View v) {
            super(v);
//            mTextView = v.findViewById(R.id.text_view);

            imageView = v.findViewById(R.id.image_view);
            textView = v.findViewById(R.id.text_view);
            emailView = v.findViewById(R.id.email_view);

        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)
//    public MyAdapter(String[] myDataset) {
//        mDataset = myDataset;
//    }


    // Provide a suitable constructor (depends on the kind of dataset)
    MyAdapter(List<Integer> itemImages, List<String> itemNames, List<String> itemEmails) {
        this.iImages = itemImages;
        this.iNames = itemNames;
        this.iEmails = itemEmails;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        Log.d("ViewGroup", String.valueOf(parent)); //parent : RecyclerView

        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view2, parent, false);

        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(view);

//        Log.d("onCreateViewHolder", String.valueOf(view)); //view : LinearLayout

//        return null;
        return vh;

    }

    // Replace the contents of a view (invoked by the layout manager)

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // - get element from your dataset at this position
        // - replace the contents of the view with that element
//        holder.mTextView.setText(mDataset[position]);
//        holder.mTextView.setTextSize(32);
//        Log.d("onBindViewHoleder",mDataset[position]);

        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.imageView.setImageResource(iImages.get(position));
        holder.textView.setText(iNames.get(position));
        holder.emailView.setText(iEmails.get(position));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
//        return mDataset.length;
        return iNames.size();

    }
}
