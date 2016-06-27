package io.hypertrack.meta.network.retrofit;

import java.util.List;
import java.util.Map;

import io.hypertrack.meta.model.MetaPlace;
import io.hypertrack.meta.model.OnboardingUser;
import io.hypertrack.meta.model.PlaceDTO;
import io.hypertrack.meta.model.Trip;
import io.hypertrack.meta.model.TripETAResponse;
import io.hypertrack.meta.model.User;
import io.hypertrack.meta.store.VerifyResponse;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by suhas on 25/01/16.
 */
public interface SendETAService {

    @POST("/api/v1/users/{id}/edit/")
    Call<User> updateUserName(@Path("id") int id, @Body Map<String, String> user);

    @Multipart
    @POST("/api/v1/users/{id}/add_photo/")
    Call<Map<String, Object>> updateUserProfilePic(@Path("id") int id, @PartMap Map<String, RequestBody> params);

    @POST("/api/v1/login/")
    Call<Map<String, Object>> getUser(@Body Map<String, String> phoneNumber);

    @POST("/api/v1/verify_code/")
    Call<VerifyResponse> verifyUser(@Body Map<String, String> verificationParams);

    @POST("/api/v1/resend_code/")
    Call<Map<String, Object>> resendCode(@Body Map<String, String> phoneNumber);

    @GET("/api/v1/eta/")
    Call<List<TripETAResponse>> getETA(@Query("origin") String origin, @Query("destination") String destination);

    @POST("/api/v1/trips/")
    Call<Trip> addTrip(@Body Map<String, String> tripDetails);

    @POST("/api/v1/users/{id}/create_task/")
    Call<Map<String, Object>> createTask(@Path("id") int id, @Body PlaceDTO placeDTO);

    @POST("/api/v1/places/")
    Call<MetaPlace> addPlace(@Body PlaceDTO place);

    @POST("/api/v1/places/{id}/edit/")
    Call<MetaPlace> editPlace(@Path("id") int id, @Body PlaceDTO place);

    @DELETE("/api/v1/places/{id}/")
    Call<MetaPlace> deletePlace(@Path("id") int id);

    @GET("/api/v1/places/")
    Call<List<MetaPlace>> getPlaces();

    @GET("/api/v1/users/{id}/task/")
    Call<Map <String, Object>> createTask(@Path("id") int id, @Query("destination_id") String destinationID);
}
