package myNews.view.adaptater;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import myNews.data.repositories.model.Articles;
import myNews.myNews.R;
import myNews.view.activitiesAndFragment.ArticlesWebview;

/**
 * Created by Remy Pouzet on 21/11/2019.
 */

class ArticlesViewHolder extends RecyclerView.ViewHolder {
	@BindView(R.id.Article_picture)       ImageView mPicture;
	@BindView(R.id.Article_category)      TextView  mCategory;
	@BindView(R.id.Article_underCategory) TextView  mUnderCategory;
	@BindView(R.id.Article_title)         TextView  mTitle;
	@BindView(R.id.Article_date)          TextView  mDate;
	@BindView(R.id.Articles_layout) RelativeLayout mRelativeLayout;
	
	ArticlesViewHolder(View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
		Context localContext = itemView.getContext();
	}
	
	@SuppressLint("SetTextI18n")
	void updateWithArticles(Articles articles) {
		Glide
				.with(mPicture.getContext())
				.load(articles.getUrlImage())
				.placeholder(articles.getDrawableImage())
				.into(mPicture);
		
		if (articles.getUnderCategory() != null && articles
				                                           .getUnderCategory()
				                                           .length() >= 1) {
			this.mCategory.setText(articles.getCategory() + " " + ">" + " ");
		} else {
			this.mCategory.setText(articles.getCategory());
		}
		if (articles.getUnderCategory() != null) {
			this.mUnderCategory.setText(articles.getUnderCategory());
		}
		this.mDate.setText(articles.getDate());
		this.mTitle.setText(articles.getTitle());
		
		this.mRelativeLayout.setOnClickListener(v -> {
			
			Intent articlesWebview = new Intent(mRelativeLayout.getContext(), ArticlesWebview.class);
			Bundle bundle          = new Bundle();
			bundle.putString("url", articles.getUrl());
			
			articlesWebview.putExtras(bundle);
			mRelativeLayout
					.getContext()
					.startActivity(articlesWebview);
			
		});
	}
}

