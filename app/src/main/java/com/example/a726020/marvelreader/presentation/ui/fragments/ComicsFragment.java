package com.example.a726020.marvelreader.presentation.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.a726020.marvelreader.R;
import com.example.a726020.marvelreader.base.BaseFragment;
import com.example.a726020.marvelreader.data.entity.ComicsObjects;
import com.example.a726020.marvelreader.data.model.JsonParser;
import com.example.a726020.marvelreader.presentation.presenter.ComicsFragmentPresenter;
import com.example.a726020.marvelreader.presentation.presenter.ComicsView;
import com.example.a726020.marvelreader.presentation.ui.adapter.ComicsListAdapter;

import java.util.ArrayList;
import java.util.List;

public class ComicsFragment extends BaseFragment implements ComicsView {

    RecyclerView rvComicsList;
    ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.comics_fragment, container, false);
        presenter = new ComicsFragmentPresenter(JsonParser.getInstance(getContext()));

        rvComicsList = rootView.findViewById(R.id.rvComicsList);
        progressBar = rootView.findViewById(R.id.progressBar);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new ComicsFragmentPresenter(JsonParser.getInstance(getContext()));
        presenter.attach(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvComicsList.setLayoutManager(layoutManager);
        List<ComicsObjects> comicsObjectsList = new ArrayList<>();
        ComicsListAdapter adapter = new ComicsListAdapter(comicsObjectsList,this);
        rvComicsList.setAdapter(adapter);
        ((ComicsFragmentPresenter)presenter).start();

    }

    @Override
    public void displayLoader() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoader() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void showComics(List<ComicsObjects> comicsObjects) {
       List<ComicsObjects> comicsClone = new ArrayList<>();
        ComicsListAdapter adapter = new ComicsListAdapter(comicsClone,this);
        rvComicsList.setAdapter(adapter);
        for (ComicsObjects comics:comicsObjects
             ) {
            comicsClone.add(comics);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}
