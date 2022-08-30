package com.example.fstore.RecyclerViewAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fstore.Data.Furniture;
import com.example.fstore.Data.FurnitureType;
import com.example.fstore.Data.TheStore;
import com.example.fstore.Fragments.homeFragments.home_product;
import com.example.fstore.Home;
import com.example.fstore.R;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class HomeMainRecyclerViewAdapter extends RecyclerView.Adapter<HomeMainRecyclerViewAdapter.ViewHolder> {

    private FurnitureType type;
    private List<Furniture> f ;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView img;
        private final MaterialButton add;
        private final TextView name;
        private final TextView price;
        public ViewHolder(View view) {
            super(view);
            img = view.findViewById(R.id.homeMainRecyclerImg);
            add = view.findViewById(R.id.homeMainRecyclerAdd);
            name = view.findViewById(R.id.homeMainRecyclerName);
            price = view.findViewById(R.id.homeMainRecyclerPrice);
        }

        public ImageView getImg(){
            return img;
        }
        public MaterialButton getAdd(){
            return add;
        }
        public TextView getName() {
            return name;
        }
        public TextView getPrice() {
            return price;
        }
    }

    public HomeMainRecyclerViewAdapter(FurnitureType type) {
        this.type = type;
        f = TheStore.getFurnitureFromType(type);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.__home_main_recycler, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        //viewHolder.getTextView().setText(localDataSet[position]);

        viewHolder.getImg().setImageResource(f.get(position).imgID);
        viewHolder.getName().setText(f.get(position).name);
        viewHolder.getPrice().setText("" + f.get(position).price);
        viewHolder.getAdd().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.home.SwitchFragment(new home_product(viewHolder.getAdapterPosition()));
            }
        });


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return f.size();
    }
}
