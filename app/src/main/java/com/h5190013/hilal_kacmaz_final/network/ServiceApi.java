package com.h5190013.hilal_kacmaz_final.network;

import com.h5190013.hilal_kacmaz_final.model.PhotographyModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    @GET("photographyJson.json")
    Observable<List<PhotographyModel>> getPhotography();
}
