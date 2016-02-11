package be.kdg.teamd.beatbuddy.dal;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

public class RepositoryFactory {
    private static Retrofit retrofit;
    private static UserRepository userRepository;

    public static UserRepository getUserRepository() {
        if(userRepository == null) userRepository = retrofit.create(UserRepository.class);
        return userRepository;
    }

    public static void setAPIEndpoint(String APIEndpoint) {
        if(retrofit == null) retrofit = new Retrofit.Builder()
                .baseUrl(APIEndpoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}