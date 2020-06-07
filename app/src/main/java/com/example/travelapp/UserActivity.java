package com.example.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        ViewPager2 locationsViewPager = findViewById(R.id.locatonsViewPager);

        List<TravelLocation> travelLocations = new ArrayList<>();

        TravelLocation travelLocationEiffelTower = new TravelLocation();
        travelLocationEiffelTower.imageUrl = "https://www.infinityandroid.com/images/france_eiffel_tower.jpg";
        travelLocationEiffelTower.title = "France";
        travelLocationEiffelTower.location = "Eiffel Tower";
        travelLocationEiffelTower.starRating = 4.8f;
        travelLocations.add(travelLocationEiffelTower);

        TravelLocation travelLocationMountainView = new TravelLocation();
        travelLocationMountainView.imageUrl = "https://www.infinityandroid.com/images/indonesia_mountain_view.jpg";
        travelLocationMountainView.title = "Indonesia";
        travelLocationMountainView.location = "Mountain View";
        travelLocationMountainView.starRating = 4.5f;
        travelLocations.add(travelLocationMountainView);

        TravelLocation travelLocationTajMahal = new TravelLocation();
        travelLocationTajMahal.imageUrl = "https://www.infinityandroid.com/images/india_taj_mahal.jpg";
        travelLocationTajMahal.title = "India";
        travelLocationTajMahal.location = "Taj Mahal";
        travelLocationTajMahal.starRating = 4.3f;
        travelLocations.add(travelLocationTajMahal);

        TravelLocation travelLocationLakeView = new TravelLocation();
        travelLocationLakeView.imageUrl = "https://www.infinityandroid.com/images/canada_lake_view.jpg";
        travelLocationLakeView.title = "Canada";
        travelLocationLakeView.location = "Lake View";
        travelLocationLakeView.starRating = 4.2f;
        travelLocations.add(travelLocationLakeView);

        locationsViewPager.setAdapter(new TravelLocationsAdapter(travelLocations));

        locationsViewPager.setClipToPadding(false);
        locationsViewPager.setClipChildren(false);
        locationsViewPager.setOffscreenPageLimit(3);
        locationsViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.95f + r * 0.05f);
            }
        });

        locationsViewPager.setPageTransformer(compositePageTransformer);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, ExploreActivity.class);
                startActivity(intent);
            }
        });
    }

}
