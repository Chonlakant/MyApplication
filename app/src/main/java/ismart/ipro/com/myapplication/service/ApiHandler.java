package ismart.ipro.com.myapplication.service;

import android.content.Context;
import android.util.Log;
import com.squareup.otto.Subscribe;

import ismart.ipro.com.myapplication.event.ApiBus;
import ismart.ipro.com.myapplication.event.ArticlesReceivedEvent;
import ismart.ipro.com.myapplication.event.ArticlesRequestedEvent;
import ismart.ipro.com.myapplication.event.EnnigyReceivedEvent;
import ismart.ipro.com.myapplication.event.EnningRequestedEvent;
import ismart.ipro.com.myapplication.event.FeedReceivedEvent;
import ismart.ipro.com.myapplication.event.FeedRequestedEvent;
import ismart.ipro.com.myapplication.event.IsoReceivedEvent;
import ismart.ipro.com.myapplication.event.IsoRequestedEvent;
import ismart.ipro.com.myapplication.event.LogisiticsRequestedEvent;
import ismart.ipro.com.myapplication.event.LogisticsReceivedEvent;
import ismart.ipro.com.myapplication.event.MaintenanceReceivedEvent;
import ismart.ipro.com.myapplication.event.MaintenanceRequestedEvent;
import ismart.ipro.com.myapplication.event.ManagemantReceivedEvent;
import ismart.ipro.com.myapplication.event.ManagementRequestedEvent;
import ismart.ipro.com.myapplication.event.NewsReceivedEvent;
import ismart.ipro.com.myapplication.event.NewsRequestedEvent;
import ismart.ipro.com.myapplication.event.PhotoReceivedEvent;
import ismart.ipro.com.myapplication.event.PhotoRequestedEvent;
import ismart.ipro.com.myapplication.event.ProductionReceivedEvent;
import ismart.ipro.com.myapplication.event.ProductionRequestedEvent;
import ismart.ipro.com.myapplication.event.PurchaseReceivedEvent;
import ismart.ipro.com.myapplication.event.PurchaseRequestedEvent;
import ismart.ipro.com.myapplication.event.QualityReceivedEvent;
import ismart.ipro.com.myapplication.event.QualityRequestedEvent;
import ismart.ipro.com.myapplication.event.SafetyReceivedEvent;
import ismart.ipro.com.myapplication.event.SafetyRequestedEvent;
import ismart.ipro.com.myapplication.event.SaleReceivedEvent;
import ismart.ipro.com.myapplication.event.SaleRequestedEvent;
import ismart.ipro.com.myapplication.event.SuccessReceivedEvent;
import ismart.ipro.com.myapplication.event.SuccessRequestedEvent;
import ismart.ipro.com.myapplication.event.TipReceivedEvent;
import ismart.ipro.com.myapplication.event.TipRequestedEvent;
import ismart.ipro.com.myapplication.event.TraingReceivedEvent;
import ismart.ipro.com.myapplication.event.TraingRequestedEvent;
import ismart.ipro.com.myapplication.model.Post;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ApiHandler {

    public Context context;
    private ApiService api;
    private ApiBus apiBus;

    public ApiHandler(Context context, ApiService api,
                      ApiBus apiBus) {

        this.context = context;
        this.api = api;
        this.apiBus = apiBus;
    }

    public void registerForEvents() {
        apiBus.register(this);
    }


    @Subscribe
    public void onGetLogistics(final LogisiticsRequestedEvent event) {
        api.getLogistics(new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {

                if (post.getPost() != null) {
//                    for(int i = 0; i < post.getPost().size();i++){
//                        ApiBus.getInstance().postQueue(new ImagesReceivedEvent(post));
//                    }

                    ApiBus.getInstance().postQueue(new LogisticsReceivedEvent(post));
                }

            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("error", error.getLocalizedMessage());
                Log.e("error", error.getUrl());
            }
        });
    }

    @Subscribe
    public void onGetQuality(final QualityRequestedEvent event) {
        api.getQuality(new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {

                if (post.getPost() != null) {
//                    for(int i = 0; i < post.getPost().size();i++){
//                        ApiBus.getInstance().postQueue(new ImagesReceivedEvent(post));
//                    }

                    ApiBus.getInstance().postQueue(new QualityReceivedEvent(post));
                }

            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("error", error.getLocalizedMessage());
                Log.e("error", error.getUrl());
            }
        });
    }

    @Subscribe
    public void onGetSafety(final SafetyRequestedEvent event) {
        api.getSafet(new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {

                if (post.getPost() != null) {
//                    for(int i = 0; i < post.getPost().size();i++){
//                        ApiBus.getInstance().postQueue(new ImagesReceivedEvent(post));
//                    }

                    ApiBus.getInstance().postQueue(new SafetyReceivedEvent(post));
                }

            }

            @Override
            public void failure(RetrofitError error) {
//                Log.e("error", error.getLocalizedMessage());
//                Log.e("error", error.getUrl());
            }
        });
    }

    @Subscribe
    public void onGetProduction(final ProductionRequestedEvent event) {
        api.getProduction(new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {

                if (post.getPost() != null) {
//                    for(int i = 0; i < post.getPost().size();i++){
//                        ApiBus.getInstance().postQueue(new ImagesReceivedEvent(post));
//                    }

                    ApiBus.getInstance().postQueue(new ProductionReceivedEvent(post));
                }

            }

            @Override
            public void failure(RetrofitError error) {
            }
        });
    }

    @Subscribe
    public void onGetMainten(final MaintenanceRequestedEvent event) {
        api.getMainten(new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {

                if (post.getPost() != null) {
//                    for(int i = 0; i < post.getPost().size();i++){
//                        ApiBus.getInstance().postQueue(new ImagesReceivedEvent(post));
//                    }

                    ApiBus.getInstance().postQueue(new MaintenanceReceivedEvent(post));
                }

            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("error", error.getLocalizedMessage());
                Log.e("error", error.getUrl());
            }
        });
    }

    @Subscribe
    public void onGetManagement(final ManagementRequestedEvent event) {
        api.getManagment(new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {

                if (post.getPost() != null) {
//                    for(int i = 0; i < post.getPost().size();i++){
//                        ApiBus.getInstance().postQueue(new ImagesReceivedEvent(post));
//                    }

                    ApiBus.getInstance().postQueue(new ManagemantReceivedEvent(post));
                }

            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("error", error.getLocalizedMessage());
                Log.e("error", error.getUrl());
            }
        });
    }

    @Subscribe
    public void onGetIso(final IsoRequestedEvent event) {
        api.getIso(new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {

                if (post.getPost() != null) {
//                    for(int i = 0; i < post.getPost().size();i++){
//                        ApiBus.getInstance().postQueue(new ImagesReceivedEvent(post));
//                    }

                    ApiBus.getInstance().postQueue(new IsoReceivedEvent(post));
                }

            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("error", error.getLocalizedMessage());
                Log.e("error", error.getUrl());
            }
        });
    }

    @Subscribe
    public void onPurchase(final PurchaseRequestedEvent event) {
        api.getPurchase(new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {

                if (post.getPost() != null) {
//                    for(int i = 0; i < post.getPost().size();i++){
//                        ApiBus.getInstance().postQueue(new ImagesReceivedEvent(post));
//                    }

                    ApiBus.getInstance().postQueue(new PurchaseReceivedEvent(post));
                }

            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("error", error.getLocalizedMessage());
                Log.e("error", error.getUrl());
            }
        });
    }

    @Subscribe
    public void onSale(final SaleRequestedEvent event) {
        api.getSale(new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {

                if (post.getPost() != null) {
//                    for(int i = 0; i < post.getPost().size();i++){
//                        ApiBus.getInstance().postQueue(new ImagesReceivedEvent(post));
//                    }

                    ApiBus.getInstance().postQueue(new SaleReceivedEvent(post));
                }

            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("error", error.getLocalizedMessage());
                Log.e("error", error.getUrl());
            }
        });
    }

    @Subscribe
    public void onArticles(final ArticlesRequestedEvent event) {
        api.getArticles(event.getVendor(), new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {
                ApiBus.getInstance().postQueue(new ArticlesReceivedEvent(post));
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Subscribe
    public void onNews(final NewsRequestedEvent event) {
        api.getNews(event.getVendor(), new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {
                ApiBus.getInstance().postQueue(new NewsReceivedEvent(post));
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Subscribe
    public void onTip(final TipRequestedEvent event) {
        api.getTip(event.getVendor(), new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {
                ApiBus.getInstance().postQueue(new TipReceivedEvent(post));
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Subscribe
    public void onTraing(final TraingRequestedEvent event) {
        api.getTraing(event.getVendor(), new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {
                ApiBus.getInstance().postQueue(new TraingReceivedEvent(post));
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Subscribe
    public void onEning(final EnningRequestedEvent event) {
        api.getEnnigy(event.getVendor(), new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {
                ApiBus.getInstance().postQueue(new EnnigyReceivedEvent(post));
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Subscribe
    public void onSuccess(final SuccessRequestedEvent event) {
        api.getSuccess(event.getVendor(), new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {
                ApiBus.getInstance().postQueue(new SuccessReceivedEvent(post));
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Subscribe
    public void onTrain(final TraingRequestedEvent event) {
        api.getTrain(new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {

                for (int i = 1; i < post.getPost().size(); i++) {
                    ApiBus.getInstance().postQueue(new TraingReceivedEvent(post));
                }

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Subscribe
    public void onFeed(final FeedRequestedEvent event) {
        api.getFeed(new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {

                for (int i = 1; i < post.getPost().size(); i++) {
                    ApiBus.getInstance().postQueue(new FeedReceivedEvent(post));
                    Log.e("dddd", post.getPost().get(i).getFile_img());
                }

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
    @Subscribe
    public void onPhoto(final PhotoRequestedEvent event) {
        api.getPhoto(new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {

                for (int i = 1; i < post.getPost().size(); i++) {
                    ApiBus.getInstance().postQueue(new PhotoReceivedEvent(post));

                }


            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
