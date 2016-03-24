package ismart.ipro.com.myapplication.event;

import ismart.ipro.com.myapplication.model.Post;

/**
 * Created by marcus on 22/04/15
 */

public class QualityReceivedEvent {

    private static final String TAG = QualityReceivedEvent.class.getSimpleName();
    private Post post;

    public QualityReceivedEvent(Post post){
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}