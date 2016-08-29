package com.example.bayar.rxgetstarted;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    }

    @OnClick(R.id.add_item) void addItem() {
        String name = mName.getText().toString();
        String importance = mImportance.getText().toString();
        Task task = new Task(name, Integer.valueOf(importance));
        mListener.addItem(task);
        dismiss();
    }

    @OnClick(R.id.cancel) void cancelAction() {
        dismiss();
    }
}
