package ismart.ipro.com.myapplication.event;


import ismart.ipro.com.myapplication.model.Post;

/**
 * Created by marcus on 22/04/15
 */

public class PurchaseReceivedEvent {

    private static final String TAG = PurchaseReceivedEvent.class.getSimpleName();
    private Post post;

    public PurchaseReceivedEvent(Post post){
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}