package com.example.hackku2019;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;



public class RSSRead extends AsyncTask<Void, Void, Void> {
    Context context;
    ProgressDialog progressDialog;
    ArrayList<FeedItem> feedItems;
    ArrayList<String> gameLinks;
    ArrayList<String> gameNames;
    ListView listView;

    public RSSRead(Context context, ListView listView){
        this.context = context;
        this.listView = listView;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading");
    }

    public String getLink(int pos){
        return(gameLinks.get(pos));
    }

    @Override
    protected void onPreExecute(){
        progressDialog.show();
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void res){
        super.onPostExecute(res);
        progressDialog.dismiss();
        //ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, feedItems);

        ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, gameNames);


        listView.setAdapter(adapter);


    }

    @Override
    protected Void doInBackground(Void... params){
        ProcessXml(getData());
        return(null);
    }

    private void ProcessXml(Document data){
        if(data != null){
            feedItems = new ArrayList<>();
            gameLinks = new ArrayList<>();
            gameNames = new ArrayList<>();
            Element root = data.getDocumentElement();
            Node channel = root.getChildNodes().item(0);
            NodeList items = channel.getChildNodes();
            for(int i = 0; i < items.getLength(); i++){
                Node currentChild = items.item(i);
                if(currentChild.getNodeName().equalsIgnoreCase("item")){
                    FeedItem item = new FeedItem();

                    NodeList itemChildren = currentChild.getChildNodes();
                    for(int j = 0; j < itemChildren.getLength(); j++){
                        Node current = itemChildren.item(j);
                        if(current.getNodeName().equalsIgnoreCase("title")){
                            String names;
                            String titles = current.getTextContent();
                            names = (titles.substring(titles.lastIndexOf(")") + 1));
                            names = names.replace("#", "");
                            gameNames.add(names);
                            item.setDescription(current.getTextContent());
                        }
                        else if(current.getNodeName().equalsIgnoreCase("description")){
                            item.setQuarter(current.getTextContent());
                        }
                        else if(current.getNodeName().equalsIgnoreCase("pubdate")){
                            item.setDateAndTime(current.getTextContent());
                        }
                        else if(current.getNodeName().equalsIgnoreCase("guid")){
                            gameLinks.add(current.getTextContent());
                            item.setGameLink(current.getTextContent());
                        }
                    }

                    feedItems.add(item);
                    Log.d("itemDescription", item.getDescription());
                    Log.d("itemQuarter", item.getQuarter());
                    Log.d("itemDateAndTime", item.getDateAndTime());
                    Log.d("itemGameLink", item.getGameLink());

                }
            }

        }


    }

    public Document getData(){
        try {
            String address = "https://www.scorespro.com/rss2/live-basketball.xml";
            URL url = new URL(address);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDoc = builder.parse(inputStream);

            return (xmlDoc);
        } catch (Exception e){
            e.printStackTrace();
            return (null);
        }


    }


}