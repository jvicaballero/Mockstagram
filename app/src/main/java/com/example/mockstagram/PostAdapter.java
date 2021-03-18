package com.example.mockstagram;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mockstagram.fragments.PostFragment;
import com.parse.ParseFile;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private Context context;
    private List<Post> posts;

    public PostAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void clear() {
        Log.i("PostAdapter" , "Clearing Data");
        posts.clear();
        notifyDataSetChanged();
    }
//
    //This is already implemented in query post
//    //Add a list of items -- change to type used
//    public void addAll(List<Post> posts) {
//        posts.addAll(posts);
//        notifyDataSetChanged();
//    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvUsername;
        private ImageView ivImage;
        private TextView tvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }

        public void bind(Post post) {
            tvDescription.setText(post.getDescription());
            tvUsername.setText(post.getUser().getUsername());

            ParseFile image = post.getImage();

            if(image != null)
                Glide.with(context).load(post.getImage().getUrl()).into(ivImage);


        }
    }
}
