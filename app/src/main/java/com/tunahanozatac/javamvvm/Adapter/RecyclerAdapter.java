package com.tunahanozatac.javamvvm.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.tunahanozatac.javamvvm.BR;
import com.tunahanozatac.javamvvm.model.UserModel;
import com.tunahanozatac.javamvvm.R;
import com.tunahanozatac.javamvvm.databinding.RecyclerListItemBinding;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<UserModel> dataModelList;
    private Context context;
    private RecyclerViewItemClickListener clickListener;


    public RecyclerAdapter(List<UserModel> dataModelList, Context context, RecyclerViewItemClickListener listener) {
        this.dataModelList = dataModelList;
        this.context = context;
        this.clickListener = listener;
    }


    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerListItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater
                        .from(parent.getContext()), R.layout.recycler_list_item, parent, false);
        return new ViewHolder(binding, parent);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        UserModel userModel = dataModelList.get(position);
        holder.bind(userModel);
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public RecyclerListItemBinding itemListUserBinding;

        public ViewHolder(@NonNull RecyclerListItemBinding itemListUserBinding, View iteView) {
            super(itemListUserBinding.getRoot());
            this.itemListUserBinding = itemListUserBinding;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onItemClick(v, getAdapterPosition());
                }
            });
        }

        public void bind(Object obj) {
            itemListUserBinding.setVariable(BR.data, obj);
            itemListUserBinding.executePendingBindings();
        }
    }
}
