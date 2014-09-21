package ca.waterloo.watisfood;

import ca.waterloo.watisfood.OutletData;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Kevin on 20/09/2014.
 */

public interface DataInterface {
    @GET("/v2/foodservices/locations.xml?key=f41a069b66774984b6e9d1c406432122")
    void report(
            Callback<OutletData> cb
    );
}