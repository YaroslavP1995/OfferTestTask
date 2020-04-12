package com.example.offerwalltestapp.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.offerwalltestapp.R;
import com.example.offerwalltestapp.model.content.ObjectModelId;
import com.example.offerwalltestapp.model.content.TypeModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ShowTextFragment extends Fragment {
    private static final int LAYOUT_RES = R.layout.fragment_show_text;

    private String content;
    @BindView(R.id.text)
    TextView text;

    private Unbinder unbinder;


    public ShowTextFragment(String content) {
        this.content = content;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_show_text, container, false);
        unbinder = ButterKnife.bind(this, v);
        text.setText(content);
        return v;

    }

}
