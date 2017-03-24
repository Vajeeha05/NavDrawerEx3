package com.example.jiji.navdrawerex3;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Frag_four extends Fragment {

    ImageClass imageClass;
    private String urlJsonArray = "http://192.168.43.153/phpfiles/select_image.php";
    private List<ImageClass> imageList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ImageAdapter adapter;
    private static String TAG = Frag_four.class.getSimpleName();
    ProgressDialog pDialog;

    public Frag_four() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_frag_four, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        adapter = new ImageAdapter(imageList,getActivity());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

//        pDialog = new ProgressDialog(getActivity());
//        pDialog.setMessage("Please wait..");
//        pDialog.setCancelable(false);

        prepareImageData();
        return view;
    }

    private void prepareImageData() {

        JsonArrayRequest req = new JsonArrayRequest(urlJsonArray, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());
                try{
                for (int i =0; i<response.length();i++){
                        JSONObject m = (JSONObject) response.get(i);
                    String title = m.getString("Name");
                    String imageUrl = m.getString("Image Url");

                 //   Glide.with(getContext()).load(imageUrl).into(imageClass.setImageId());
                    imageClass = new ImageClass(title,imageUrl);
                    imageList.add(imageClass);
                    }

                    recyclerView.setAdapter(adapter);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                        Toast.makeText(getActivity(),"Error "+error.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
        );

        AppController.getInstance().addToRequestQueue(req);
    }
}
