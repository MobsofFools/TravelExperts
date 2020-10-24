package com.edvinlin.travelexperts.ui.profiles;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfilesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ProfilesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}