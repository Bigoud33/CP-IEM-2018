package com.example.a726020.marvelreader.presentation.presenter;

import com.example.a726020.marvelreader.base.BaseView;
import com.example.a726020.marvelreader.data.entity.ComicsObjects;

import java.util.List;

public interface ComicsView extends BaseView {

    @Override
    void displayLoader();

    @Override
    void hideLoader();

    @Override
    void showError(Throwable throwable);

    void showComics(List<ComicsObjects> comicsObjects);
}
