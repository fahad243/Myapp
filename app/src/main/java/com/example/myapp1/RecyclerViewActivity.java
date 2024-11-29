package com.example.myapp1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("Tesla Model S"));
        itemList.add(new Item("Ford Mustang"));
        itemList.add(new Item("Chevrolet Camaro"));
        itemList.add(new Item("Toyota Corolla"));
        itemList.add(new Item("Honda Civic"));
        itemList.add(new Item("BMW 3 Series"));
        itemList.add(new Item("Mercedes-Benz C-Class"));
        itemList.add(new Item("Audi A4"));
        itemList.add(new Item("Volkswagen Golf"));
        itemList.add(new Item("Nissan Altima"));
        itemList.add(new Item("Hyundai Elantra"));
        itemList.add(new Item("Kia Optima"));
        itemList.add(new Item("Mazda CX-5"));
        itemList.add(new Item("Subaru Outback"));
        itemList.add(new Item("Jeep Wrangler"));
        itemList.add(new Item("Chevrolet Silverado"));
        itemList.add(new Item("Ram 1500"));
        itemList.add(new Item("Ford F-150"));
        itemList.add(new Item("Lexus RX"));
        itemList.add(new Item("Porsche 911"));


        ItemAdapter adapter = new ItemAdapter(itemList);
        recyclerView.setAdapter(adapter);
    }
}
