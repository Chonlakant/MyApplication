package ismart.ipro.com.myapplication.event;


import ismart.ipro.com.myapplication.model.Post;

/**
 * Created by marcus on 22/04/15
 */

public class MaintenanceReceivedEvent {

    private static final String TAG = MaintenanceReceivedEvent.class.getSimpleName();
    private Post post;

    public MaintenanceReceivedEvent(Post post){
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}