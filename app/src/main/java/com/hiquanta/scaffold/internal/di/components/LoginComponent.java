package com.hiquanta.scaffold.internal.di.components;

import com.hiquanta.scaffold.internal.di.PerActivity;
import com.hiquanta.scaffold.internal.di.modules.ActivityModule;
import com.hiquanta.scaffold.internal.di.modules.LoginModule;
import com.hiquanta.scaffold.view.activity.LoginActivity;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by hiquanta on 2016/10/10.
 */
@PerActivity
@Subcomponent( modules = {ActivityModule.class, LoginModule.class})
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
