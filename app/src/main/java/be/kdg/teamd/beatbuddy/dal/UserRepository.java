package be.kdg.teamd.beatbuddy.dal;

import java.util.List;

import be.kdg.teamd.beatbuddy.model.organisations.Organisation;
import be.kdg.teamd.beatbuddy.model.playlists.Playlist;
import be.kdg.teamd.beatbuddy.model.users.AccessToken;
import be.kdg.teamd.beatbuddy.model.users.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserRepository {
    public static final String GRANT_TYPE = "password";

    @POST("token")
    @Headers({"Accept: application/json"})
    @FormUrlEncoded
    Call<AccessToken> login(@Field("grant_type") String grantType, @Field("username") String email, @Field("password") String password);

    @GET("users/{id}/")
    Call<User> userInfo(@Path("id") String email);

    @POST("users/register")
    Call<User> register(@Query("firstName") String firstName, @Query("lastName") String lastName, @Query("nickname") String nickname, @Query("email") String email, @Query("password") String password);

    @POST("users/gplusRegister")
    Call<User> registerGplus(@Query("firstName") String firstName, @Query("lastName") String lastName, @Query("nickname") String nickname, @Query("email") String email, @Query("password") String password, @Query("imageUrl") String imageUrl);

    @GET("users/userOrganisations")
    Call<List<Organisation>> getUserOrganisations();

    @GET("users/userPlaylists")
    Call<List<Playlist>> getUserPlaylists();
}
