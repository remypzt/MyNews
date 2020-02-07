package myNews.data.service.realAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
	private static Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("https://api.nytimes.com/svc/")
			.addConverterFactory(GsonConverterFactory.create())
			.build();
	
	public static <S> S cteateService(Class<S> serviceClass) {
		return retrofit.create(serviceClass);
	}
}
