package ca.waterloo.watisfood;

import ca.waterloo.watisfood.OutletData;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Kevin on 20/09/2014.
 */

public interface DataInterface {
    @GET("")
    void report(
            Callback<OutletData> cb
    );
}