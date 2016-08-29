package com.example.bayar.rxgetstarted;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.jakewharton.rxbinding.view.RxView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddItemFragment extends DialogFragment {

    public interface addItemFromInterface {
        void addItem(Task task);
    }

    public static AddItemFragment newInstance() {
        return new AddItemFragment();
    }

    @BindView(R.id.et_name)
    EditText mName;
    @BindView(R.id.et_importance)
    EditText mImportance;
    @BindView(R.id.add_item)
    Button mAddItem;
    @BindView(R.id.cancel)
    Button mCancel;

    private MainActivity mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_item, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        mListener = (MainActivity) getActivity();

        RxView.clicks(mAddItem)
                .map(aVoid1 -> {
                    String name = mName.getText().toString();
                    String importance = mImportance.getText().toString();
                    if (importance.isEmpty()) {
                        importance = "0";
                    }
                    return new Task(name, Integer.valueOf(importance));
                })
                .subscribe(task -> {
                    mListener.addItem(task);
                    dismiss();
                });

        RxView.clicks(mCancel)
                .subscribe(aVoid -> dismiss());
    }
}
