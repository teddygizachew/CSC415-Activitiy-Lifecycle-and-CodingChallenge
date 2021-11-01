package com.nkufall2021.shoppinglistapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final int TEXT_REQUEST = 1;

    private RecyclerView mRecyclerView;
    private ShoppingListAdapter mAdapter;
    private final LinkedList<String> linkedList = new LinkedList<>();
    LinkedList<String> savedLinkedList;
    TextView itemWordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        mRecyclerView = findViewById(R.id.recyclerview);
        itemWordTextView = findViewById(R.id.word);

        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new ShoppingListAdapter(this, linkedList);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Restore the state
        if (savedInstanceState != null) {
//            itemWordTextView.setText(savedInstanceState.getString("reply_text"));
            savedLinkedList = (LinkedList<String>)savedInstanceState.getSerializable("reply_array");

            // Get a handle to the RecyclerView.
            mRecyclerView = findViewById(R.id.recyclerview);
            // Create an adapter and supply the data to be displayed.
            mAdapter = new ShoppingListAdapter(this, linkedList);
            // Connect the adapter with the RecyclerView.
            mRecyclerView.setAdapter(mAdapter);
            // Give the RecyclerView a default layout manager.
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "launchSecondActivity: Button clicked");
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                if (!linkedList.contains(reply)) {
                    linkedList.addLast(reply);
                }

                // Get a handle to the RecyclerView.
                mRecyclerView = findViewById(R.id.recyclerview);
                // Create an adapter and supply the data to be displayed.
                mAdapter = new ShoppingListAdapter(this, linkedList);
                // Connect the adapter with the RecyclerView.
                mRecyclerView.setAdapter(mAdapter);
                // Give the RecyclerView a default layout manager.
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            }
        }
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
//        itemWordTextView = findViewById(R.id.word);
//        outState.putString("reply_text", itemWordTextView.getText().toString());
        outState.putSerializable("reply_array", linkedList);
    }
}