package com.tunahanozatac.javamvvm.viewmodel;

import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tunahanozatac.javamvvm.View.DetailActivity;
import com.tunahanozatac.javamvvm.model.UserModel;
import com.tunahanozatac.javamvvm.Repo.UserDataRepo;

import java.util.List;

public class MainViewModel extends ViewModel {

    private UserDataRepo userDataRepo;
    public MutableLiveData<List<UserModel>> userData;
    private Context context;

    public void init(Context context) {
        this.context = context;

        if (userData != null) {
            return;
        }
        //repo tanımlanıyor.
        userDataRepo = UserDataRepo.init();
        // repo altındaki live data viewmodel aktarılıyor.
        userData = userDataRepo.getUserData();

    }

    public void openDetailPage(UserModel model) {

        /*
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("name", model.name);
        context.startActivity(intent);
        */
        context.startActivity(DetailActivity.launchDetail(context, model));


    }

}
