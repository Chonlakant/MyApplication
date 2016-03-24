package ismart.ipro.com.myapplication.event;


import ismart.ipro.com.myapplication.model.Post;

/**
 * Created by marcus on 22/04/15
 */

public class TraingReceivedEvent {

    private static final String TAG = TraingReceivedEvent.class.getSimpleName();
    private Post post;

    public TraingReceivedEvent(Post post){
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}