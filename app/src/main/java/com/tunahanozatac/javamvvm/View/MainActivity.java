package com.tunahanozatac.javamvvm.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.tunahanozatac.javamvvm.Adapter.RecyclerViewItemClickListener;
import com.tunahanozatac.javamvvm.R;
import com.tunahanozatac.javamvvm.Adapter.RecyclerAdapter;
import com.tunahanozatac.javamvvm.viewmodel.MainViewModel;
import com.tunahanozatac.javamvvm.model.UserModel;

import java.util.List;


public class MainActivity extends AppCompatActivity implements RecyclerViewItemClickListener {

    private MainViewModel viewModel;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Kullanıcı ile etkileşim olacak işlemleri yaptık.

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        //viewmodel çalıştırlıyor.
        viewModel.init(this);
        setRecyclerView();
        //livedatea dinliyor.
        viewModel.userData.observe(this, new Observer<List<UserModel>>() {
            @Override
            public void onChanged(List<UserModel> userModels) {

                Log.e("data changed", ":" + userModels);
                adapter = new RecyclerAdapter(viewModel.userData.getValue(), MainActivity.this, MainActivity.this);
                recyclerView.setAdapter(adapter);
            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        viewModel.openDetailPage(viewModel.userData.getValue().get(position));
    }

    private void setRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}