package com.hiquanta.domain.view.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.hiquanta.domain.AppContext;
import com.hiquanta.domain.internal.di.components.ApplicationComponent;
import com.hiquanta.domain.internal.di.modules.ActivityModule;
import com.hiquanta.domain.navigation.Navigator;

import javax.inject.Inject;

/**
 * Created by hiquanta on 2016/9/26.
 */

public abstract class BaseActivity extends Activity {

    @Inject
    Navigator navigator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppContext.get().getApplicationComponent().inject(this);
    }
    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }
    protected ApplicationComponent getApplicationComponent() {
        return AppContext.get().getApplicationComponent();
    }
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

}