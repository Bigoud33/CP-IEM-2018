package com.example.a726020.marvelreader.data.model;

import android.content.Context;

import com.example.a726020.marvelreader.R;
import com.example.a726020.marvelreader.data.entity.ComicsObjects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JsonParser implements JsonParserInterface {

    Context context;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private JsonParser(Context context) {
        this.context = context;
    }

    private JsonParser()
    {}

    private static JsonParser INSTANCE = null;


    public static JsonParser getInstance(Context context) {
        if (INSTANCE == null)
        {   INSTANCE = new JsonParser(context);
        }
        return INSTANCE;
    }

    public String loadJSONFromRaw()  {
        String json = null;
        try {
            //here to change json to parse
            InputStream is = context.getResources().openRawResource(R.raw.sample_ok);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public List<ComicsObjects> populateComicsList()  {

        List<ComicsObjects> comicsObjectsListCopy = new ArrayList<>();
        try {
            JSONObject jsonObject = null;
            jsonObject = new JSONObject(loadJSONFromRaw());
            JSONArray jsonArray = jsonObject.getJSONArray("results");

            for (int i = 0; i < jsonArray.length(); i++) {

                ComicsObjects comicsObjects = new ComicsObjects();
                JSONObject result = jsonArray.getJSONObject(i);

                comicsObjects.setTitle(result.getString("title"));
                try {
                    comicsObjects.setDate(simpleDateFormat.parse(result.getString("date")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                comicsObjects.setPageCount(result.getInt("pageCount"));
                comicsObjects.setImage(result.getString("image"));

                comicsObjectsListCopy.add(comicsObjects);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return comicsObjectsListCopy;
    }


}
