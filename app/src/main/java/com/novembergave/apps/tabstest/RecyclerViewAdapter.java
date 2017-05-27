package com.novembergave.apps.tabstest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by novembergave on 27/05/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewOne;
        public ViewHolder(View itemView) {
            super(itemView);
            mTextViewOne = (TextView) itemView.findViewById(R.id.textview_one);
        }

    }

    private List<String> stringList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.stringList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View transactionsView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(transactionsView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextViewOne.setText(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

}
