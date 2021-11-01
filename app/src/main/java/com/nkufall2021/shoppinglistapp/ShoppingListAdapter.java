package com.nkufall2021.shoppinglistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ShoppingListViewHolder> {

    public ShoppingListAdapter(Context context, LinkedList<String> shopList) {
        mInflater = LayoutInflater.from(context);
        this.mShopList = shopList;
    }

    private final LinkedList<String> mShopList;
    private LayoutInflater mInflater;

    class ShoppingListViewHolder extends RecyclerView.ViewHolder {
        public final TextView shopItemView;
        final ShoppingListAdapter mAdapter;

        public ShoppingListViewHolder(View itemView, ShoppingListAdapter adapter) {
            super(itemView);
            shopItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
        }
    }

    @NonNull
    @Override
    public ShoppingListAdapter.ShoppingListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.list_item, parent, false);
        return new ShoppingListViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingListAdapter.ShoppingListViewHolder holder, int position) {
        String mCurrent = mShopList.get(position);
        holder.shopItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mShopList.size();
    }
}
