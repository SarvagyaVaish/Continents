package com.survy.continents;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.continents_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        ContinentAdapter adapter = new ContinentAdapter();
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}

class ContinentAdapter extends RecyclerView.Adapter<ContinentAdapter.ContinentViewHolder> {

    private List<String> continentsList = new ArrayList<>();

    public ContinentAdapter() {
        continentsList.add("Asia");
        continentsList.add("Africa");
        continentsList.add("North America");
        continentsList.add("South America");
        continentsList.add("Antarctica");
        continentsList.add("Europe");
        continentsList.add("Australia");
    }

    @Override
    public ContinentAdapter.ContinentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.view_continent_list_item, parent, false);

        return new ContinentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContinentAdapter.ContinentViewHolder holder, int position) {
        String name = continentsList.get(position);
        holder.name.setText(name);
    }

    @Override
    public int getItemCount() {
        return continentsList.size();
    }

    class ContinentViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public ContinentViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.continent_name);
        }
    }
}