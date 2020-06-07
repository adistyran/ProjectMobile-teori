package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.travelapp.adapter.TripsAdapter;
import com.example.travelapp.models.Ads;
import com.example.travelapp.models.Item;
import com.example.travelapp.models.News;
import com.example.travelapp.models.Trip;

import java.util.ArrayList;
import java.util.List;

public class ExploreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        List<Item> items = new ArrayList<>();

        //Trip1
        Trip trip1 = new Trip(R.drawable.croatia, "Croatia", "Summer 2020 - 20 Days");
        items.add(new Item(0, trip1));

        Ads ads1 = new Ads("Ad : Summer Holiday", "70% OFF on New Year Sale");
        items.add(new Item(1, ads1));

        News news1 = new News(
                "Croatia,Southeast Europe",
                "To visit Croatia is to become part of its landscape of natural wonders. Its national parks may be the country’s best known conservation areas, but even in the nation’s capital, Zagreb, visitors are surrounded by protected regional parks, forests and even a mountain."
        );
        items.add(new Item(2, news1));

        //Trip2
        Trip trip2 = new Trip(R.drawable.rajaampat, "Raja Ampat", "Summer 2020 - 10 Days");
        items.add(new Item(0, trip2));

        News news2 = new News(
                "Raja Ampat,Indonesia",
                "Often called one of the last unspoiled places in the world. The lush islands dotted across crystal blue waters draw travellers from all over the world. Raja Ampat on the whole is stunning."
        );
        items.add(new Item(2, news2));

        //Trip3
        Trip trip3 = new Trip(R.drawable.bali, "Bali", "Summer 2020 - 15 Days");
        items.add(new Item(0, trip3));

        News news3 = new News(
                "Bali,Indonesia",
                "Bali appeals through its sheer natural beauty of looming volcanoes and lush terraced rice fields that exude peace and serenity. It is also famous for surfers' paradise!"
        );
        items.add(new Item(2, news3));

        //Trip4
        Trip trip4 = new Trip(R.drawable.newzealand, "New Zealand", "Winter 2020 - 12 Days");
        items.add(new Item(0, trip4));

        Ads ads2 = new Ads("Ad : New Year Holiday", "50% OFF on Your First Trip");
        items.add(new Item(1, ads2));

        News news4 = new News(
                "New Zealand",
                "New Zealand is famous the world over for its incredible scenery, ranging from sweeping mountains to vast underground cave systems, golden-sand beaches to rugged coastline. It's also packed with cool cities, hidden spots, wonderful wildlife, and more."
        );
        items.add(new Item(2, news4));

        //Trip5
        Trip trip5 = new Trip(R.drawable.japan, "Japan", "Winter 2020 - 9 Days");
        items.add(new Item(0, trip5));

        Ads ads3 = new Ads("Ad : Christmas Holiday", "Save Up tp 50%");
        items.add(new Item(1, ads3));

        News news5 = new News(
                "Japan",
                "Japan is known worldwide for its traditional arts, including tea ceremonies, calligraphy and flower arranging. The country has a legacy of distinctive gardens, sculpture and poetry. "
        );
        items.add(new Item(2, news5));

        recyclerView.setAdapter(new TripsAdapter(items));
    }
}
