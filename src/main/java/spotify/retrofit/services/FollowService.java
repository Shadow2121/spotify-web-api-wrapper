package spotify.retrofit.services;

import retrofit2.Call;
import retrofit2.http.*;
import spotify.api.enums.EntityType;
import spotify.models.playlists.FollowPlaylistRequestBody;

import java.util.List;

public interface FollowService {
    @GET("me/following/contains")
    Call<List<Boolean>> isFollowing(@Header("Authorization") String accessToken, @Query("type") EntityType entityType, @Query("ids") String entityIds);

    @GET("playlists/{playlist_id}/followers/contains")
    Call<List<Boolean>> isFollowingPlaylist(@Header("Authorization") String accessToken, @Path("playlist_id") String playlistId, @Query("ids") String userIds);

    @PUT("me/following")
    Call<Void> followEntity(@Header("Authorization") String accessToken, @Query("type") EntityType entityType, @Query("ids") String entityIds);

    @PUT("playlists/{playlist_id}/followers")
    Call<Void> followPlaylist(@Header("Authorization") String accessToken,
                              @Path("playlist_id") String playlistId,
                              @Body FollowPlaylistRequestBody setPlaylistPublic);
}
