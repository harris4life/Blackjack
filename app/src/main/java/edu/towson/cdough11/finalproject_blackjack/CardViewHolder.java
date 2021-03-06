package edu.towson.cdough11.finalproject_blackjack;

import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import edu.towson.cdough11.finalproject_blackjack.Models.Card;

/**
 * Created by tsuba on 11/12/2017.
 */

public class CardViewHolder extends RecyclerView.ViewHolder {

    ImageView image;
    Card card;

    public CardViewHolder(View itemView){
        super(itemView);
        image = (ImageView)itemView.findViewById(R.id.imageView);
    }

    public void bindCard(Card card){
        image.setImageResource(card.getImageID());
        this.card = card;
    }
}