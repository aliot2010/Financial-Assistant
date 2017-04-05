package Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aliot1.pizzaapp.R;

/**
 * Created by aliot on 13.09.2016.
 */
public class CaptionImageAdapter extends RecyclerView.Adapter<CaptionImageAdapter.ViewHolder> {//переименовать класс

    private  int[] captions;
    private int[] images;

    public CaptionImageAdapter(int[] captions, int[] images) {//вместо массивов передовать объекты "дни" с массивами трат
        this.captions = captions;
        this.images = images;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv=(CardView) LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card_captioned_image, parent, false);//card caption image меняем на day_day_card
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            CardView cardView = holder.cardView;
        ImageView imageView=(ImageView) cardView.findViewById(R.id.info_image);

        imageView.setImageDrawable(cardView.getResources().getDrawable(images[position]));
        //imageView.setContentDescription(captions[position]);
        TextView textView = (TextView)cardView.findViewById(R.id.info_text);
        textView.setText(captions[position]);
    }

    @Override
    public int getItemCount() {
        return captions.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;

        public  ViewHolder(CardView v){
            super(v);
            cardView=v;
        }
    }


}
