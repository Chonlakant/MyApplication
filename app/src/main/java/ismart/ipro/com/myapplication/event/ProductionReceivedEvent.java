package ismart.ipro.com.myapplication.event;


import ismart.ipro.com.myapplication.model.Post;

/**
 * Created by marcus on 22/04/15
 */

public class ProductionReceivedEvent {

    private static final String TAG = ProductionReceivedEvent.class.getSimpleName();
    private Post post;

    public ProductionReceivedEvent(Post post){
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}