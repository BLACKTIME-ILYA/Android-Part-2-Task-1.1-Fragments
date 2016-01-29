package com.sourceit.task1.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.sourceit.task1.R;
import com.sourceit.task1.utils.L;


public class TopFragment extends Fragment {

    public static TopFragment newInstance() {
        TopFragment fragment = new TopFragment();
        return fragment;
    }

    private EditText num1;
    private EditText num2;
    private EditText num3;
    private int temp_num;
    private final int UPDATE_TIME = 3000;
    private final int MSG = 1;

    public TopFragment() {
    }

    NumChangeListener listener;

    Handler h = new Handler() {
        @Override
        public void dispatchMessage(Message msg) {
            if (msg.what == 1) {
                listener.numChange(temp_num);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container_top, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top, container_top, false);
        L.d("onCreateView_top");
        num1 = (EditText) view.findViewById(R.id.editTextNum1);
        L.d("create num 1");
        num2 = (EditText) view.findViewById(R.id.editTextNum2);
        num3 = (EditText) view.findViewById(R.id.editTextNum3);

        num1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    temp_num = Integer.parseInt(s.toString());
                    changeDelay();
                } catch (NumberFormatException e) {};
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        num2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    temp_num = Integer.parseInt(s.toString());
                    changeDelay();
                } catch (NumberFormatException e) {};
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        num3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    temp_num = Integer.parseInt(s.toString());
                    changeDelay();
                } catch (NumberFormatException e) {};
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        return view;
    }

    private void changeDelay(){
            if (h.hasMessages(MSG)){
                h.removeMessages(MSG);
            }
            h.sendEmptyMessageDelayed(MSG, UPDATE_TIME);
    }

    public void setNumChangeListener(NumChangeListener listener) {
        this.listener = listener;
    }
}
