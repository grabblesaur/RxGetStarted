package com.example.bayar.rxgetstarted;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements AddItemFragment.addItemFromInterface{

    private static final String TAG = "ghjcnjnfr";

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private List<Task> mTaskList = new ArrayList<>();
    private TaskAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAdapter = new TaskAdapter(mTaskList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @OnClick(R.id.fab) void onFabClick() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        AddItemFragment fragment = AddItemFragment.newInstance();
        fragment.show(transaction, "add_item_dialog");
    }

    @Override
    public void addItem(Task task) {
        mTaskList.add(task);
        mAdapter.notifyItemInserted(mTaskList.size());
        mAdapter.notifyItemRangeChanged(mTaskList.size(), mTaskList.size());
    }
}
