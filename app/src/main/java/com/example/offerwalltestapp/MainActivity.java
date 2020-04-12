package com.example.offerwalltestapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.offerwalltestapp.model.MainErrorModel;
import com.example.offerwalltestapp.model.content.ObjectModelId;
import com.example.offerwalltestapp.model.content.TypeModel;
import com.example.offerwalltestapp.screens.ShowTextFragment;
import com.example.offerwalltestapp.screens.ShowWebViewFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView{
    private final String LOG_TAG = getClass().getSimpleName();
    private static final int LAYOUT_RES = R.layout.activity_main;
    private static final String TEXT = "text";
    private static final String WEB_VIEW = "webview";
    private static final String GAME = "game";

    @BindView(R.id.button)
    CardView button;
    @BindView(R.id.frame_container)
    FrameLayout frame_container;

    protected Fragment currentFragment;
    private ShowTextFragment showTextFragment;
    private ShowWebViewFragment showWebViewFragment;
    private int count = 0;
    List<ObjectModelId> objectModelIds = new ArrayList<>();
    private MainPresenter presenter;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT_RES);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this);
        presenter.getTrending();
    }

    @OnClick(R.id.button)
    public void click() {
        if (objectModelIds != null && count < objectModelIds.size()-1 ){
            count++;
            presenter.getTrending();
        }else {
            count = 0;
        }
    }

    @Override
    public void typeModel(@NonNull TypeModel typeModel) {
        postMenuDialogClickAction(typeModel.getType(), typeModel.getContents());
        Log.d(LOG_TAG, typeModel.getType());
        if (typeModel.getType().equals(WEB_VIEW)){
            postMenuDialogClickAction(typeModel.getType(), typeModel.getUrl());
            Log.d(LOG_TAG, typeModel.getUrl());
        }
    }

    @Override
    public void objectModelId(List<ObjectModelId> getTrending) {
        objectModelIds.addAll(getTrending);
        presenter.getType((int) objectModelIds.get(count).getId());
    }

    @Override
    public void handleError(Throwable throwable) {
        if (throwable instanceof MainErrorModel) {
            System.out.println(throwable.getMessage());
            if (((MainErrorModel) throwable).getCode().equals(402)) {
                Toast.makeText(this, R.string.error, Toast.LENGTH_LONG).show();
            }
        }
    }

    public void postMenuDialogClickAction(String type, String content) {
        switch (type) {
            case TEXT:
                showTextFragment = new ShowTextFragment(content);
                currentFragment = showTextFragment;
                frame_container.setVisibility(View.VISIBLE);
                replaceFragment(currentFragment, true);
                break;
            case WEB_VIEW:
                showWebViewFragment = new ShowWebViewFragment(content);
                frame_container.setVisibility(View.VISIBLE);
                currentFragment = showWebViewFragment;
                replaceFragment(currentFragment, true);
                break;
            case GAME:
                frame_container.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }

    public void replaceFragment(Fragment fragment, boolean toBackStack) {
        currentFragment = fragment;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, currentFragment, "ShowTextFragmentTag");
        if (toBackStack) {
            fragmentTransaction.addToBackStack("ShowWebViewFragmentTag").commit();
        } else {
            fragmentTransaction.commit();
        }
    }
}
