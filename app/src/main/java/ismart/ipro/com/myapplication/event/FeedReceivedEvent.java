package ismart.ipro.com.myapplication.event;


import ismart.ipro.com.myapplication.model.Post;

/**
 * Created by marcus on 22/04/15
 */

public class FeedReceivedEvent {

    private static final String TAG = FeedReceivedEvent.class.getSimpleName();
    private Post post;

    public FeedReceivedEvent(Post post){
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}