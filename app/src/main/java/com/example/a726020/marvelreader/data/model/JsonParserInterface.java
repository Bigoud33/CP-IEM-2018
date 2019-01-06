package com.example.a726020.marvelreader.data.model;

import com.example.a726020.marvelreader.data.entity.ComicsObjects;

import java.util.List;

public interface JsonParserInterface {


    String loadJSONFromRaw();
    List<ComicsObjects> populateComicsList();
}
