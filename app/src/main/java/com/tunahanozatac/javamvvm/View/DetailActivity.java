package com.tunahanozatac.javamvvm.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.tunahanozatac.javamvvm.R;
import com.tunahanozatac.javamvvm.databinding.ActivityDetailBinding;
import com.tunahanozatac.javamvvm.model.UserModel;
import com.tunahanozatac.javamvvm.viewmodel.DetailViewModel;

public class DetailActivity extends AppCompatActivity {

    Intent intent;
    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        getExtrasFromIntent();
        /*
        intent = getIntent();
        String name = intent.getStringExtra("name");
        */

    }

    private void getExtrasFromIntent() {
        UserModel usermodel = (UserModel) getIntent().getSerializableExtra("name");
        DetailViewModel detailViewModel = new DetailViewModel(usermodel);
        binding.setDetailViewModel(detailViewModel);
        setTitle(usermodel.name);
    }

    public static Intent launchDetail(Context context, UserModel model) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("name", model);
        return intent;
    }


}