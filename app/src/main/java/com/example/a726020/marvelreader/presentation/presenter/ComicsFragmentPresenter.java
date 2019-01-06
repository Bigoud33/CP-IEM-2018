package com.example.a726020.marvelreader.presentation.presenter;

import com.example.a726020.marvelreader.base.BasePresenter;
import com.example.a726020.marvelreader.data.model.JsonParserInterface;

public class ComicsFragmentPresenter extends BasePresenter<ComicsView> {

    JsonParserInterface jsonParserInterface;

    public ComicsFragmentPresenter(JsonParserInterface jsonParserInterface) {
        this.jsonParserInterface = jsonParserInterface;
    }

    public JsonParserInterface getJsonParserInterface() {
        return jsonParserInterface;
    }

    public void start() {
        getUnsafeView().displayLoader();
        getComics();
    }

    public void getComics(){
        getUnsafeView().showComics(jsonParserInterface.populateComicsList());
        getUnsafeView().hideLoader();
    }

}
