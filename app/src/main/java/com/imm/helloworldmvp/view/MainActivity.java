package com.imm.helloworldmvp.view;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.imm.helloworldmvp.R;
import com.imm.helloworldmvp.presenter.MainActivityPresenter;


public class MainActivity extends AppCompatActivity
        implements MainActivityPresenter.View {

    private MainActivityPresenter mPresenter;
    private TextView myTextView;
    private ProgressBar progressBar;
    private EditText userName,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainActivityPresenter(this);

        myTextView = findViewById(R.id.myTextView);
        userName = findViewById(R.id.username);
        email = findViewById(R.id.email);

        initProgressBar();

        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                mPresenter.updateFullName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                hideProgressbar();
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                mPresenter.updateEmail(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

                hideProgressbar();

            }
        });

    }

    private void initProgressBar() {
        progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleSmall);
        progressBar.setIndeterminate(true);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Resources.getSystem().getDisplayMetrics().widthPixels,
                150);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        this.addContentView(progressBar, params);
        showProgressBar();
    }

    @Override
    public void updateUserInfoTextView(String info) {

        myTextView.setText(info);
    }

    @Override
    public void showProgressBar() {

        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {

        progressBar.setVisibility(View.INVISIBLE);
    }
}
