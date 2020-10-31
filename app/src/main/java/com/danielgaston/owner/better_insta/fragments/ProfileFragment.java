package com.danielgaston.owner.better_insta.fragments;

import android.util.Log;

import com.danielgaston.owner.better_insta.Post;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ProfileFragment extends PostFragment {
    @Override
    protected void queryPosts() {
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
        query.setLimit(20);
        query.addDescendingOrder(Post.KEY_CREATED_AT);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if(e!=null){
                    return;
                }
                for (Post post:posts){
                    Log.i("Post",post.getDescription() + " And ");
                }
                adapter.clear();
                adapter.addAll(posts);
                swipeContainer.setRefreshing(false);
                adapter.notifyDataSetChanged();
//                allPosts.addAll(posts);
//                adapter.notifyDataSetChanged();

            }
        });

    }
}
