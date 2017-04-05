package Adapters;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aliot1.pizzaapp.R;

import java.util.List;

import realmClasses.CostRealmObject;

/**
 * Created by aliot on 13.09.2016.
 */
public class CaptionImageAdapter extends RecyclerView.Adapter<CaptionImageAdapter.ViewHolder> {//переименовать класс

    private  List<CostRealmObject> listOfCosts;

    public CaptionImageAdapter(List<CostRealmObject> listOfCosts) {//вместо массивов передовать объекты "дни" с массивами трат

        this.listOfCosts = listOfCosts;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv=(CardView) LayoutInflater.from(parent.getContext()).
                inflate(R.layout.day_card, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        TextView costTextView = (TextView) cardView.findViewById(R.id.costTextView);

        costTextView.setText((listOfCosts.get(position)).getCost().toString());
        setTextColor(costTextView, listOfCosts.get(position).getCost() < 0 );
    }

    private  void  setTextColor(TextView textView, boolean isNegative){
        if (isNegative) {
            textView.setTextColor(Color.RED);
        } else {
            textView.setTextColor(Color.GREEN);
        }
    }

    @Override
    public int getItemCount() {
        return listOfCosts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;

        public  ViewHolder(CardView v){
            super(v);
            cardView=v;
        }
    }


}
