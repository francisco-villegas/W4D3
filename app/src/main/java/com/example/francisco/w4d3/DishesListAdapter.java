package com.example.francisco.w4d3;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail;
import com.beardedhen.androidbootstrap.BootstrapWell;
import com.example.francisco.w4d3.model.Dishes;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by FRANCISCO on 10/08/2017.
 */

public class DishesListAdapter extends RecyclerView.Adapter<DishesListAdapter.ViewHolder> {

    private static final String TAG = "DishesListAdapter";
    ArrayList<Dishes> DishesList = new ArrayList<>();
    Context context;

    public DishesListAdapter(ArrayList<Dishes> DishesList) {
        this.DishesList = DishesList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Nullable
        @BindView(R.id.img)
        BootstrapCircleThumbnail img;

        @Nullable
        @BindView(R.id.tvName)
        TextView tvName;

        @Nullable
        @BindView(R.id.tvRegion)
        TextView tvRegion;

        @Nullable
        @BindView(R.id.tvType)
        TextView tvType;

        @Nullable
        @BindView(R.id.tvDescription)
        TextView tvDescription;

        @Nullable
        @BindView(R.id.scroll)
        ScrollView scroll;

        @Nullable
        @BindView(R.id.scroll_parent)
        FrameLayout scroll_parent;

        @Nullable
        @BindView(R.id.tvNameParent)
        BootstrapWell tvNameParent;

        public ViewHolder(View DishesView) {
            super(DishesView);
            ButterKnife.bind(this, DishesView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Log.d(TAG, "onCreateViewHolder: ");
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    private int lastPosition = -1;
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        if(position > lastPosition){
            //Animation animation = AnimationUtils
        }

        //Log.d(TAG, "onBindViewHolder: ");
        final Dishes Dishess = DishesList.get(position);
        Picasso.with(context).load(Dishess.getUrl()).error(R.drawable.ic_image).into(holder.img);
        if(!Dishess.getName().trim().equals(""))
            holder.tvName.setText(Dishess.getName());
        else
            holder.tvNameParent.setVisibility(holder.tvNameParent.getRootView().GONE);

        if(!Dishess.getRegion().trim().equals(""))
            holder.tvRegion.setText(Dishess.getRegion());
        else
            holder.tvRegion.setVisibility(holder.tvRegion.getRootView().GONE);

        if(!Dishess.getType().trim().equals(""))
            holder.tvType.setText(Dishess.getType());
        else
            holder.tvType.setVisibility(holder.tvType.getRootView().GONE);

        if(!Dishess.getDescription().trim().equals(""))
            holder.tvDescription.setText(Dishess.getDescription());
        else
            holder.tvDescription.setVisibility(holder.tvDescription.getRootView().GONE);

        holder.scroll.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                if(holder.scroll.getChildAt(0).getHeight() > holder.scroll_parent.getMeasuredHeight()) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        //Log.d(TAG, "getDishesCount: "+DishesList.size());
        return DishesList.size();
    }
}
