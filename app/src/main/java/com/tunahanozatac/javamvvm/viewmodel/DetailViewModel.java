package com.tunahanozatac.javamvvm.viewmodel;

import com.tunahanozatac.javamvvm.model.UserModel;

public class DetailViewModel {

    private UserModel model;

    public DetailViewModel(UserModel model) {
        this.model = model;
    }

    public String getName() {
        return model.name;
    }
}
