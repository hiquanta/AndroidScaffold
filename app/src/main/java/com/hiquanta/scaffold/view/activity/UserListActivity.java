package com.hiquanta.scaffold.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.hiquanta.scaffold.AppContext;
import com.hiquanta.scaffold.R;
import com.hiquanta.scaffold.internal.di.HasComponent;
import com.hiquanta.scaffold.internal.di.components.UserComponent;
import com.hiquanta.scaffold.internal.di.modules.UserModule;
import com.hiquanta.scaffold.model.UserModel;
import com.hiquanta.scaffold.view.fragment.UserListFragment;

/**
 * Created by hiquanta on 2016/9/26.
 */

public class UserListActivity extends BaseActivity implements HasComponent<UserComponent>,
        UserListFragment.UserListListener{
    public static Intent getCallingIntent(Context context) {
        return new Intent(context, UserListActivity.class);
    }
    private UserComponent userComponent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        this.initializeInjector();
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new UserListFragment());
        }
    }
    private void initializeInjector() {
//        this.userComponent = DaggerUserComponent.builder()
//                .applicationComponent(getApplicationComponent())
//                .activityModule(getActivityModule())
//                .build();
        this.userComponent= AppContext.get().getApplicationComponent().plus(new UserModule());

    }
    @Override
    public UserComponent getComponent() {
        return userComponent;
    }

    @Override
    public void onUserClicked(UserModel userModel) {
        this.navigator.navigateToUserDetails(this, userModel.getUserId());
    }
}
