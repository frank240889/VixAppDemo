package dev.franco.vixapi.domain.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    @SerialName("data")
    val `data`: Data? = null,
) {
    @Serializable
    data class Data(
        @SerialName("uiPage")
        val uiPage: UiPage? = null,
    ) {
        @Serializable
        data class UiPage(
            @SerialName("pageAnalyticsMetadata")
            val pageAnalyticsMetadata: PageAnalyticsMetadata? = null,
            @SerialName("pageContentAvailability")
            val pageContentAvailability: PageContentAvailability? = null,
            @SerialName("pageName")
            val pageName: String? = null,
            @SerialName("uiModules")
            val uiModules: UiModules? = null,
            @SerialName("urlPath")
            val urlPath: String? = null,
        ) {
            @Serializable
            data class PageAnalyticsMetadata(
                @SerialName("keyValues")
                val keyValues: List<KeyValue?>? = null,
            ) {
                @Serializable
                data class KeyValue(
                    @SerialName("key")
                    val key: String? = null,
                    @SerialName("value")
                    val value: String? = null,
                )
            }

            @Serializable
            data class PageContentAvailability(
                @SerialName("isBlocked")
                val isBlocked: Boolean? = null,
                @SerialName("reason")
                val reason: String? = null,
            )

            @Serializable
            data class UiModules(
                @SerialName("edges")
                val edges: List<Edge?>? = null,
                @SerialName("pageInfo")
                val pageInfo: PageInfo? = null,
                @SerialName("totalCount")
                val totalCount: Int? = null,
            ) {
                @Serializable
                data class Edge(
                    @SerialName("cursor")
                    val cursor: String? = null,
                    @SerialName("node")
                    val node: Node? = null,
                ) {
                    @Serializable
                    data class Node(
                        @SerialName("caption")
                        val caption: String? = null,
                        @SerialName("contents")
                        val contents: Contents? = null,
                        @SerialName("id")
                        val id: String? = null,
                        @SerialName("isLive")
                        val isLive: Boolean? = null,
                        @SerialName("landscapeFillImage")
                        val landscapeFillImage: LandscapeFillImage? = null,
                        @SerialName("leagueId")
                        val leagueId: String? = null,
                        @SerialName("moduleType")
                        val moduleType: String? = null,
                        @SerialName("portraitFillImage")
                        val portraitFillImage: PortraitFillImage? = null,
                        @SerialName("scrollingTimeSeconds")
                        val scrollingTimeSeconds: String? = null,
                        @SerialName("sportId")
                        val sportId: String? = null,
                        @SerialName("sportsEventCarouselType")
                        val sportsEventCarouselType: String? = null,
                        @SerialName("title")
                        val title: String? = null,
                        @SerialName("trackingId")
                        val trackingId: String? = null,
                        @SerialName("trackingMetadataJson")
                        val trackingMetadataJson: TrackingMetadataJson? = null,
                        @SerialName("treatment")
                        val treatment: String? = null,
                    ) {
                        @Serializable
                        data class Contents(
                            @SerialName("edges")
                            val edges: List<Edge?>? = null,
                            @SerialName("pageInfo")
                            val pageInfo: PageInfo? = null,
                            @SerialName("totalCount")
                            val totalCount: Int? = null,
                        ) {
                            @Serializable
                            data class Edge(
                                @SerialName("cursor")
                                val cursor: String? = null,
                                @SerialName("node")
                                val node: Node? = null,
                            ) {
                                @Serializable
                                data class Node(
                                    @SerialName("awayTeamLogo")
                                    val awayTeamLogo: AwayTeamLogo? = null,
                                    @SerialName("channel")
                                    val channel: Channel? = null,
                                    @SerialName("channelId")
                                    val channelId: String? = null,
                                    @SerialName("clickTrackingJson")
                                    val clickTrackingJson: ClickTrackingJson? = null,
                                    @SerialName("compositeImageLink")
                                    val compositeImageLink: String? = null,
                                    @SerialName("heroTarget")
                                    val heroTarget: HeroTarget? = null,
                                    @SerialName("heroTargetContentType")
                                    val heroTargetContentType: String? = null,
                                    @SerialName("image")
                                    val image: Image? = null,
                                    @SerialName("landscapeFillImage")
                                    val landscapeFillImage: LandscapeFillImage? = null,
                                    @SerialName("localTeamLogo")
                                    val localTeamLogo: LocalTeamLogo? = null,
                                    @SerialName("logoImage")
                                    val logoImage: LogoImage? = null,
                                    @SerialName("mobileFillImage")
                                    val mobileFillImage: MobileFillImage? = null,
                                    @SerialName("portraitFillImage")
                                    val portraitFillImage: PortraitFillImage? = null,
                                    @SerialName("schedule")
                                    val schedule: Schedule? = null,
                                    @SerialName("sponsorMetadata")
                                    val sponsorMetadata: String? = null,
                                    @SerialName("sportsEvent")
                                    val sportsEvent: SportsEvent? = null,
                                    @SerialName("sportsEventId")
                                    val sportsEventId: String? = null,
                                    @SerialName("stream")
                                    val stream: Stream? = null,
                                    @SerialName("textTitle")
                                    val textTitle: String? = null,
                                    @SerialName("tournamentCardBackground")
                                    val tournamentCardBackground: TournamentCardBackground? = null,
                                    @SerialName("tournamentLogo")
                                    val tournamentLogo: TournamentLogo? = null,
                                    @SerialName("tournamentSplashBackground")
                                    val tournamentSplashBackground: TournamentSplashBackground? = null,
                                    @SerialName("video")
                                    val video: Video? = null,
                                ) {
                                    @Serializable
                                    data class AwayTeamLogo(
                                        @SerialName("filePath")
                                        val filePath: String? = null,
                                        @SerialName("imageRole")
                                        val imageRole: String? = null,
                                        @SerialName("link")
                                        val link: String? = null,
                                        @SerialName("mediaType")
                                        val mediaType: String? = null,
                                    )

                                    @Serializable
                                    data class Channel(
                                        @SerialName("badges")
                                        val badges: List<String?>? = null,
                                        @SerialName("channelAvailability")
                                        val channelAvailability: ChannelAvailability? = null,
                                        @SerialName("trackingMetadata")
                                        val trackingMetadata: TrackingMetadata? = null,
                                    ) {
                                        @Serializable
                                        data class ChannelAvailability(
                                            @SerialName("isBlocked")
                                            val isBlocked: Boolean? = null,
                                            @SerialName("reason")
                                            val reason: String? = null,
                                        )

                                        @Serializable
                                        data class TrackingMetadata(
                                            @SerialName("advertisingMetadata")
                                            val advertisingMetadata: AdvertisingMetadata? = null,
                                            @SerialName("advertisingMetadataJson")
                                            val advertisingMetadataJson: AdvertisingMetadataJson? = null,
                                            @SerialName("analyticsMetadataJson")
                                            val analyticsMetadataJson: AnalyticsMetadataJson? = null,
                                            @SerialName("sharedMetadataJson")
                                            val sharedMetadataJson: SharedMetadataJson? = null,
                                        ) {
                                            @Serializable
                                            data class AdvertisingMetadata(
                                                @SerialName("adConfiguration")
                                                val adConfiguration: AdConfiguration? = null,
                                                @SerialName("adUnit")
                                                val adUnit: String? = null,
                                            ) {
                                                @Serializable
                                                data class AdConfiguration(
                                                    @SerialName("correlator")
                                                    val correlator: String? = null,
                                                    @SerialName("cust_params")
                                                    val custParams: String? = null,
                                                    @SerialName("description_url")
                                                    val descriptionUrl: String? = null,
                                                    @SerialName("env")
                                                    val env: String? = null,
                                                    @SerialName("gdfp_req")
                                                    val gdfpReq: String? = null,
                                                    @SerialName("impl")
                                                    val impl: String? = null,
                                                    @SerialName("iu")
                                                    val iu: String? = null,
                                                    @SerialName("npa")
                                                    val npa: String? = null,
                                                    @SerialName("server_url")
                                                    val serverUrl: String? = null,
                                                    @SerialName("ss_req")
                                                    val ssReq: String? = null,
                                                    @SerialName("sz")
                                                    val sz: String? = null,
                                                    @SerialName("tfcd")
                                                    val tfcd: String? = null,
                                                    @SerialName("unviewed_position_start")
                                                    val unviewedPositionStart: String? = null,
                                                    @SerialName("url")
                                                    val url: String? = null,
                                                    @SerialName("vad_type")
                                                    val vadType: String? = null,
                                                    @SerialName("vconp")
                                                    val vconp: String? = null,
                                                    @SerialName("vpa")
                                                    val vpa: String? = null,
                                                    @SerialName("vpi")
                                                    val vpi: String? = null,
                                                )
                                            }

                                            @Serializable
                                            class AdvertisingMetadataJson

                                            @Serializable
                                            data class AnalyticsMetadataJson(
                                                @SerialName("channel_number")
                                                val channelNumber: String? = null,
                                                @SerialName("channel_video_schedule_end_date")
                                                val channelVideoScheduleEndDate: String? = null,
                                                @SerialName("channel_video_schedule_start_date")
                                                val channelVideoScheduleStartDate: String? = null,
                                            )

                                            @Serializable
                                            data class SharedMetadataJson(
                                                @SerialName("carousel_id")
                                                val carouselId: String? = null,
                                                @SerialName("carousel_title")
                                                val carouselTitle: String? = null,
                                                @SerialName("channel_ads_key")
                                                val channelAdsKey: String? = null,
                                                @SerialName("channel_id")
                                                val channelId: String? = null,
                                                @SerialName("channel_title")
                                                val channelTitle: String? = null,
                                                @SerialName("content_group")
                                                val contentGroup: String? = null,
                                                @SerialName("epg_channel_type")
                                                val epgChannelType: String? = null,
                                                @SerialName("is_epg")
                                                val isEpg: String? = null,
                                                @SerialName("is_recommendation")
                                                val isRecommendation: String? = null,
                                                @SerialName("navigation_section")
                                                val navigationSection: String? = null,
                                                @SerialName("stream_type")
                                                val streamType: String? = null,
                                                @SerialName("video_content_genres")
                                                val videoContentGenres: String? = null,
                                                @SerialName("video_content_vertical")
                                                val videoContentVertical: List<String?>? = null,
                                                @SerialName("video_genres")
                                                val videoGenres: List<String?>? = null,
                                                @SerialName("video_genres_first")
                                                val videoGenresFirst: String? = null,
                                                @SerialName("video_id_external")
                                                val videoIdExternal: String? = null,
                                                @SerialName("video_language")
                                                val videoLanguage: String? = null,
                                                @SerialName("video_rating")
                                                val videoRating: String? = null,
                                                @SerialName("video_supplier")
                                                val videoSupplier: List<String?>? = null,
                                                @SerialName("video_title")
                                                val videoTitle: String? = null,
                                                @SerialName("video_type")
                                                val videoType: String? = null,
                                            )
                                        }
                                    }

                                    @Serializable
                                    data class ClickTrackingJson(
                                        @SerialName("ui_content_group")
                                        val uiContentGroup: String? = null,
                                        @SerialName("ui_content_id")
                                        val uiContentId: String? = null,
                                        @SerialName("ui_content_title")
                                        val uiContentTitle: String? = null,
                                        @SerialName("ui_content_type")
                                        val uiContentType: String? = null,
                                    )

                                    @Serializable
                                    data class HeroTarget(
                                        @SerialName("badges")
                                        val badges: List<String?>? = null,
                                        @SerialName("contentUsage")
                                        val contentUsage: String? = null,
                                        @SerialName("dateModified")
                                        val dateModified: String? = null,
                                        @SerialName("dateReleased")
                                        val dateReleased: String? = null,
                                        @SerialName("description")
                                        val description: String? = null,
                                        @SerialName("genres")
                                        val genres: List<String?>? = null,
                                        @SerialName("id")
                                        val id: String? = null,
                                        @SerialName("imageAssets")
                                        val imageAssets: List<ImageAsset?>? = null,
                                        @SerialName("ratings")
                                        val ratings: List<Rating?>? = null,
                                        @SerialName("title")
                                        val title: String? = null,
                                        @SerialName("videoType")
                                        val videoType: String? = null,
                                        @SerialName("videoTypeData")
                                        val videoTypeData: Video.VideoTypeData? = null,
                                        @SerialName("vodAvailability")
                                        val vodAvailability: VodAvailability? = null,
                                    ) {
                                        @Serializable
                                        data class ImageAsset(
                                            @SerialName("filePath")
                                            val filePath: String? = null,
                                            @SerialName("imageRole")
                                            val imageRole: String? = null,
                                            @SerialName("link")
                                            val link: String? = null,
                                            @SerialName("mediaType")
                                            val mediaType: String? = null,
                                        )

                                        @Serializable
                                        data class Rating(
                                            @SerialName("ratingSubValues")
                                            val ratingSubValues: List<String?>? = null,
                                            @SerialName("ratingValue")
                                            val ratingValue: String? = null,
                                        )

                                        @Serializable
                                        data class VodAvailability(
                                            @SerialName("isBlocked")
                                            val isBlocked: Boolean? = null,
                                            @SerialName("reason")
                                            val reason: String? = null,
                                        )
                                    }

                                    @Serializable
                                    data class Image(
                                        @SerialName("filePath")
                                        val filePath: String? = null,
                                        @SerialName("imageRole")
                                        val imageRole: String? = null,
                                        @SerialName("link")
                                        val link: String? = null,
                                        @SerialName("mediaType")
                                        val mediaType: String? = null,
                                    )

                                    @Serializable
                                    data class LandscapeFillImage(
                                        @SerialName("filePath")
                                        val filePath: String? = null,
                                        @SerialName("imageRole")
                                        val imageRole: String? = null,
                                        @SerialName("link")
                                        val link: String? = null,
                                        @SerialName("mediaType")
                                        val mediaType: String? = null,
                                    )

                                    @Serializable
                                    data class LocalTeamLogo(
                                        @SerialName("filePath")
                                        val filePath: String? = null,
                                        @SerialName("imageRole")
                                        val imageRole: String? = null,
                                        @SerialName("link")
                                        val link: String? = null,
                                        @SerialName("mediaType")
                                        val mediaType: String? = null,
                                    )

                                    @Serializable
                                    data class LogoImage(
                                        @SerialName("filePath")
                                        val filePath: String? = null,
                                        @SerialName("imageRole")
                                        val imageRole: String? = null,
                                        @SerialName("link")
                                        val link: String? = null,
                                        @SerialName("mediaType")
                                        val mediaType: String? = null,
                                    )

                                    @Serializable
                                    data class MobileFillImage(
                                        @SerialName("filePath")
                                        val filePath: String? = null,
                                        @SerialName("imageRole")
                                        val imageRole: String? = null,
                                        @SerialName("link")
                                        val link: String? = null,
                                        @SerialName("mediaType")
                                        val mediaType: String? = null,
                                    )

                                    @Serializable
                                    data class PortraitFillImage(
                                        @SerialName("filePath")
                                        val filePath: String? = null,
                                        @SerialName("imageRole")
                                        val imageRole: String? = null,
                                        @SerialName("link")
                                        val link: String? = null,
                                        @SerialName("mediaType")
                                        val mediaType: String? = null,
                                    )

                                    @Serializable
                                    data class Schedule(
                                        @SerialName("endDate")
                                        val endDate: String? = null,
                                        @SerialName("id")
                                        val id: String? = null,
                                        @SerialName("imageAssets")
                                        val imageAssets: List<SportsEvent.AwayTeam.ImageAsset?>? = null,
                                        @SerialName("startDate")
                                        val startDate: String? = null,
                                        @SerialName("title")
                                        val title: String? = null,
                                        @SerialName("trackingMetadata")
                                        val trackingMetadata: TrackingMetadata? = null,
                                        @SerialName("video")
                                        val video: Video? = null,
                                        @SerialName("vodAvailable")
                                        val vodAvailable: Boolean? = null,
                                    ) {
                                        @Serializable
                                        data class TrackingMetadata(
                                            @SerialName("advertisingMetadata")
                                            val advertisingMetadata: AdvertisingMetadata? = null,
                                            @SerialName("advertisingMetadataJson")
                                            val advertisingMetadataJson: AdvertisingMetadataJson? = null,
                                            @SerialName("analyticsMetadataJson")
                                            val analyticsMetadataJson: AnalyticsMetadataJson? = null,
                                            @SerialName("sharedMetadataJson")
                                            val sharedMetadataJson: SharedMetadataJson? = null,
                                        ) {
                                            @Serializable
                                            data class AdvertisingMetadata(
                                                @SerialName("adConfiguration")
                                                val adConfiguration: AdConfiguration? = null,
                                                @SerialName("adUnit")
                                                val adUnit: String? = null,
                                            ) {
                                                @Serializable
                                                data class AdConfiguration(
                                                    @SerialName("correlator")
                                                    val correlator: String? = null,
                                                    @SerialName("cust_params")
                                                    val custParams: String? = null,
                                                    @SerialName("description_url")
                                                    val descriptionUrl: String? = null,
                                                    @SerialName("env")
                                                    val env: String? = null,
                                                    @SerialName("gdfp_req")
                                                    val gdfpReq: String? = null,
                                                    @SerialName("impl")
                                                    val impl: String? = null,
                                                    @SerialName("iu")
                                                    val iu: String? = null,
                                                    @SerialName("npa")
                                                    val npa: String? = null,
                                                    @SerialName("server_url")
                                                    val serverUrl: String? = null,
                                                    @SerialName("ss_req")
                                                    val ssReq: String? = null,
                                                    @SerialName("sz")
                                                    val sz: String? = null,
                                                    @SerialName("tfcd")
                                                    val tfcd: String? = null,
                                                    @SerialName("unviewed_position_start")
                                                    val unviewedPositionStart: String? = null,
                                                    @SerialName("url")
                                                    val url: String? = null,
                                                    @SerialName("vad_type")
                                                    val vadType: String? = null,
                                                    @SerialName("vconp")
                                                    val vconp: String? = null,
                                                    @SerialName("vpa")
                                                    val vpa: String? = null,
                                                    @SerialName("vpi")
                                                    val vpi: String? = null,
                                                )
                                            }

                                            @Serializable
                                            class AdvertisingMetadataJson

                                            @Serializable
                                            data class AnalyticsMetadataJson(
                                                @SerialName("channel_number")
                                                val channelNumber: String? = null,
                                                @SerialName("channel_video_schedule_end_date")
                                                val channelVideoScheduleEndDate: String? = null,
                                                @SerialName("channel_video_schedule_start_date")
                                                val channelVideoScheduleStartDate: String? = null,
                                            )

                                            @Serializable
                                            data class SharedMetadataJson(
                                                @SerialName("carousel_id")
                                                val carouselId: String? = null,
                                                @SerialName("carousel_title")
                                                val carouselTitle: String? = null,
                                                @SerialName("channel_ads_key")
                                                val channelAdsKey: String? = null,
                                                @SerialName("channel_id")
                                                val channelId: String? = null,
                                                @SerialName("channel_title")
                                                val channelTitle: String? = null,
                                                @SerialName("content_group")
                                                val contentGroup: String? = null,
                                                @SerialName("epg_channel_type")
                                                val epgChannelType: String? = null,
                                                @SerialName("is_epg")
                                                val isEpg: String? = null,
                                                @SerialName("is_recommendation")
                                                val isRecommendation: String? = null,
                                                @SerialName("navigation_section")
                                                val navigationSection: String? = null,
                                                @SerialName("stream_type")
                                                val streamType: String? = null,
                                                @SerialName("video_content_genres")
                                                val videoContentGenres: String? = null,
                                                @SerialName("video_content_vertical")
                                                val videoContentVertical: List<String?>? = null,
                                                @SerialName("video_genres")
                                                val videoGenres: List<String?>? = null,
                                                @SerialName("video_genres_first")
                                                val videoGenresFirst: String? = null,
                                                @SerialName("video_id_external")
                                                val videoIdExternal: String? = null,
                                                @SerialName("video_language")
                                                val videoLanguage: String? = null,
                                                @SerialName("video_rating")
                                                val videoRating: String? = null,
                                                @SerialName("video_supplier")
                                                val videoSupplier: List<String?>? = null,
                                                @SerialName("video_title")
                                                val videoTitle: String? = null,
                                                @SerialName("video_type")
                                                val videoType: String? = null,
                                            )
                                        }
                                    }

                                    @Serializable
                                    data class SportsEvent(
                                        @SerialName("awayTeam")
                                        val awayTeam: AwayTeam? = null,
                                        @SerialName("badges")
                                        val badges: List<String?>? = null,
                                        @SerialName("id")
                                        val id: String? = null,
                                        @SerialName("localTeam")
                                        val localTeam: LocalTeam? = null,
                                        @SerialName("name")
                                        val name: String? = null,
                                        @SerialName("playbackData")
                                        val playbackData: PlaybackData? = null,
                                        @SerialName("tournament")
                                        val tournament: Tournament? = null,
                                        @SerialName("vodAvailability")
                                        val vodAvailability: VodAvailability? = null,
                                    ) {
                                        @Serializable
                                        data class AwayTeam(
                                            @SerialName("id")
                                            val id: String? = null,
                                            @SerialName("imageAssets")
                                            val imageAssets: List<ImageAsset?>? = null,
                                            @SerialName("name")
                                            val name: String? = null,
                                        ) {
                                            @Serializable
                                            data class ImageAsset(
                                                @SerialName("filePath")
                                                val filePath: String? = null,
                                                @SerialName("imageRole")
                                                val imageRole: String? = null,
                                                @SerialName("link")
                                                val link: String? = null,
                                                @SerialName("mediaType")
                                                val mediaType: String? = null,
                                            )
                                        }

                                        @Serializable
                                        data class LocalTeam(
                                            @SerialName("id")
                                            val id: String? = null,
                                            @SerialName("imageAssets")
                                            val imageAssets: List<ImageAsset?>? = null,
                                            @SerialName("name")
                                            val name: String? = null,
                                        ) {
                                            @Serializable
                                            data class ImageAsset(
                                                @SerialName("filePath")
                                                val filePath: String? = null,
                                                @SerialName("imageRole")
                                                val imageRole: String? = null,
                                                @SerialName("link")
                                                val link: String? = null,
                                                @SerialName("mediaType")
                                                val mediaType: String? = null,
                                            )
                                        }

                                        @Serializable
                                        data class PlaybackData(
                                            @SerialName("kickoffDate")
                                            val kickoffDate: String? = null,
                                            @SerialName("scheduledEndTime")
                                            val scheduledEndTime: String? = null,
                                            @SerialName("scheduledStartTime")
                                            val scheduledStartTime: String? = null,
                                            @SerialName("stream")
                                            val stream: Stream? = null,
                                            @SerialName("streamId")
                                            val streamId: String? = null,
                                            @SerialName("trackingMetadata")
                                            val trackingMetadata: TrackingMetadata? = null,
                                        ) {
                                            @Serializable
                                            data class Stream(
                                                @SerialName("mcpId")
                                                val mcpId: String? = null,
                                            )

                                            @Serializable
                                            data class TrackingMetadata(
                                                @SerialName("advertisingMetadata")
                                                val advertisingMetadata: AdvertisingMetadata? = null,
                                                @SerialName("advertisingMetadataJson")
                                                val advertisingMetadataJson: AdvertisingMetadataJson? = null,
                                                @SerialName("analyticsMetadataJson")
                                                val analyticsMetadataJson: AnalyticsMetadataJson? = null,
                                                @SerialName("sharedMetadataJson")
                                                val sharedMetadataJson: SharedMetadataJson? = null,
                                            ) {
                                                @Serializable
                                                data class AdvertisingMetadata(
                                                    @SerialName("adConfiguration")
                                                    val adConfiguration: AdConfiguration? = null,
                                                    @SerialName("adUnit")
                                                    val adUnit: String? = null,
                                                ) {
                                                    @Serializable
                                                    data class AdConfiguration(
                                                        @SerialName("correlator")
                                                        val correlator: String? = null,
                                                        @SerialName("cust_params")
                                                        val custParams: String? = null,
                                                        @SerialName("description_url")
                                                        val descriptionUrl: String? = null,
                                                        @SerialName("env")
                                                        val env: String? = null,
                                                        @SerialName("gdfp_req")
                                                        val gdfpReq: String? = null,
                                                        @SerialName("impl")
                                                        val impl: String? = null,
                                                        @SerialName("iu")
                                                        val iu: String? = null,
                                                        @SerialName("npa")
                                                        val npa: String? = null,
                                                        @SerialName("server_url")
                                                        val serverUrl: String? = null,
                                                        @SerialName("ss_req")
                                                        val ssReq: String? = null,
                                                        @SerialName("sz")
                                                        val sz: String? = null,
                                                        @SerialName("tfcd")
                                                        val tfcd: String? = null,
                                                        @SerialName("unviewed_position_start")
                                                        val unviewedPositionStart: String? = null,
                                                        @SerialName("url")
                                                        val url: String? = null,
                                                        @SerialName("vad_type")
                                                        val vadType: String? = null,
                                                        @SerialName("vconp")
                                                        val vconp: String? = null,
                                                        @SerialName("vpa")
                                                        val vpa: String? = null,
                                                        @SerialName("vpi")
                                                        val vpi: String? = null,
                                                    )
                                                }

                                                @Serializable
                                                class AdvertisingMetadataJson

                                                @Serializable
                                                class AnalyticsMetadataJson

                                                @Serializable
                                                data class SharedMetadataJson(
                                                    @SerialName("carousel_id")
                                                    val carouselId: String? = null,
                                                    @SerialName("carousel_title")
                                                    val carouselTitle: String? = null,
                                                    @SerialName("content_group")
                                                    val contentGroup: String? = null,
                                                    @SerialName("is_epg")
                                                    val isEpg: String? = null,
                                                    @SerialName("is_recommendation")
                                                    val isRecommendation: String? = null,
                                                    @SerialName("navigation_section")
                                                    val navigationSection: String? = null,
                                                    @SerialName("sports_away_team")
                                                    val sportsAwayTeam: String? = null,
                                                    @SerialName("sports_event_id")
                                                    val sportsEventId: String? = null,
                                                    @SerialName("sports_event_mcp_id")
                                                    val sportsEventMcpId: String? = null,
                                                    @SerialName("sports_event_title")
                                                    val sportsEventTitle: String? = null,
                                                    @SerialName("sports_home_team")
                                                    val sportsHomeTeam: String? = null,
                                                    @SerialName("sports_id")
                                                    val sportsId: String? = null,
                                                    @SerialName("sports_league_id")
                                                    val sportsLeagueId: String? = null,
                                                    @SerialName("sports_league_name")
                                                    val sportsLeagueName: String? = null,
                                                    @SerialName("sports_pckg")
                                                    val sportsPckg: String? = null,
                                                    @SerialName("sports_title")
                                                    val sportsTitle: String? = null,
                                                    @SerialName("stream_type")
                                                    val streamType: String? = null,
                                                    @SerialName("video_content_vertical")
                                                    val videoContentVertical: List<String?>? = null,
                                                    @SerialName("video_genres")
                                                    val videoGenres: List<String?>? = null,
                                                    @SerialName("video_genres_first")
                                                    val videoGenresFirst: String? = null,
                                                    @SerialName("video_is_kids")
                                                    val videoIsKids: String? = null,
                                                    @SerialName("video_rating")
                                                    val videoRating: String? = null,
                                                    @SerialName("video_type")
                                                    val videoType: String? = null,
                                                )
                                            }
                                        }

                                        @Serializable
                                        data class Tournament(
                                            @SerialName("id")
                                            val id: String? = null,
                                            @SerialName("imageAssets")
                                            val imageAssets: List<ImageAsset?>? = null,
                                            @SerialName("name")
                                            val name: String? = null,
                                            @SerialName("tournamentType")
                                            val tournamentType: String? = null,
                                        ) {
                                            @Serializable
                                            data class ImageAsset(
                                                @SerialName("filePath")
                                                val filePath: String? = null,
                                                @SerialName("imageRole")
                                                val imageRole: String? = null,
                                                @SerialName("link")
                                                val link: String? = null,
                                                @SerialName("mediaType")
                                                val mediaType: String? = null,
                                            )
                                        }

                                        @Serializable
                                        data class VodAvailability(
                                            @SerialName("isBlocked")
                                            val isBlocked: Boolean? = null,
                                            @SerialName("reason")
                                            val reason: String? = null,
                                        )
                                    }

                                    @Serializable
                                    data class Stream(
                                        @SerialName("mcpId")
                                        val mcpId: String? = null,
                                    )

                                    @Serializable
                                    data class TournamentCardBackground(
                                        @SerialName("filePath")
                                        val filePath: String? = null,
                                        @SerialName("imageRole")
                                        val imageRole: String? = null,
                                        @SerialName("link")
                                        val link: String? = null,
                                        @SerialName("mediaType")
                                        val mediaType: String? = null,
                                    )

                                    @Serializable
                                    data class TournamentLogo(
                                        @SerialName("filePath")
                                        val filePath: String? = null,
                                        @SerialName("imageRole")
                                        val imageRole: String? = null,
                                        @SerialName("link")
                                        val link: String? = null,
                                        @SerialName("mediaType")
                                        val mediaType: String? = null,
                                    )

                                    @Serializable
                                    data class TournamentSplashBackground(
                                        @SerialName("filePath")
                                        val filePath: String? = null,
                                        @SerialName("imageRole")
                                        val imageRole: String? = null,
                                        @SerialName("link")
                                        val link: String? = null,
                                        @SerialName("mediaType")
                                        val mediaType: String? = null,
                                    )

                                    @Serializable
                                    data class Video(
                                        @SerialName("badges")
                                        val badges: List<String?>? = null,
                                        @SerialName("contentUsage")
                                        val contentUsage: String? = null,
                                        @SerialName("contributors")
                                        val contributors: List<Contributor?>? = null,
                                        @SerialName("copyrightYear")
                                        val copyrightYear: Int? = null,
                                        @SerialName("dateModified")
                                        val dateModified: String? = null,
                                        @SerialName("dateReleased")
                                        val dateReleased: String? = null,
                                        @SerialName("description")
                                        val description: String? = null,
                                        @SerialName("genres")
                                        val genres: List<String?>? = null,
                                        @SerialName("id")
                                        val id: String? = null,
                                        @SerialName("imageAssets")
                                        val imageAssets: List<ImageAsset?>? = null,
                                        @SerialName("language")
                                        val language: String? = null,
                                        @SerialName("ratings")
                                        val ratings: List<Rating?>? = null,
                                        @SerialName("title")
                                        val title: String? = null,
                                        @SerialName("videoType")
                                        val videoType: String? = null,
                                        @SerialName("videoTypeData")
                                        val videoTypeData: VideoTypeData? = null,
                                        @SerialName("vodAvailability")
                                        val vodAvailability: VodAvailability? = null,
                                    ) {
                                        @Serializable
                                        data class Contributor(
                                            @SerialName("name")
                                            val name: String? = null,
                                            @SerialName("roles")
                                            val roles: List<String?>? = null,
                                        )

                                        @Serializable
                                        data class ImageAsset(
                                            @SerialName("filePath")
                                            val filePath: String? = null,
                                            @SerialName("imageRole")
                                            val imageRole: String? = null,
                                            @SerialName("link")
                                            val link: String? = null,
                                            @SerialName("mediaType")
                                            val mediaType: String? = null,
                                        )

                                        @Serializable
                                        data class Rating(
                                            @SerialName("ratingSubValues")
                                            val ratingSubValues: List<String?>? = null,
                                            @SerialName("ratingValue")
                                            val ratingValue: String? = null,
                                        )

                                        @Serializable
                                        data class VideoTypeData(
                                            @SerialName("extraType")
                                            val extraType: String? = null,
                                            @SerialName("parents")
                                            val parents: List<Parent?>? = null,
                                            @SerialName("playbackData")
                                            val playbackData: PlaybackData? = null,
                                        ) {
                                            @Serializable
                                            data class Parent(
                                                @SerialName("id")
                                                val id: String? = null,
                                                @SerialName("title")
                                                val title: String? = null,
                                            )

                                            @Serializable
                                            data class PlaybackData(
                                                @SerialName("stream")
                                                val stream: Stream? = null,
                                                @SerialName("streamMetadata")
                                                val streamMetadata: StreamMetadata? = null,
                                            ) {
                                                @Serializable
                                                data class Stream(
                                                    @SerialName("mcpId")
                                                    val mcpId: String? = null,
                                                )

                                                @Serializable
                                                data class StreamMetadata(
                                                    @SerialName("duration")
                                                    val duration: Int? = null,
                                                    @SerialName("introEndPosition")
                                                    val introEndPosition: Int? = null,
                                                    @SerialName("introSkippable")
                                                    val introSkippable: Boolean? = null,
                                                    @SerialName("introStartPosition")
                                                    val introStartPosition: Int? = null,
                                                    @SerialName("outroSkippable")
                                                    val outroSkippable: Boolean? = null,
                                                    @SerialName("outroStartPosition")
                                                    val outroStartPosition: Int? = null,
                                                )
                                            }
                                        }

                                        @Serializable
                                        data class VodAvailability(
                                            @SerialName("isBlocked")
                                            val isBlocked: Boolean? = null,
                                            @SerialName("reason")
                                            val reason: String? = null,
                                        )
                                    }
                                }
                            }

                            @Serializable
                            data class PageInfo(
                                @SerialName("endCursor")
                                val endCursor: String? = null,
                                @SerialName("hasNextPage")
                                val hasNextPage: Boolean? = null,
                                @SerialName("hasPreviousPage")
                                val hasPreviousPage: Boolean? = null,
                                @SerialName("startCursor")
                                val startCursor: String? = null,
                            )
                        }

                        @Serializable
                        data class LandscapeFillImage(
                            @SerialName("filePath")
                            val filePath: String? = null,
                            @SerialName("imageRole")
                            val imageRole: String? = null,
                            @SerialName("link")
                            val link: String? = null,
                            @SerialName("mediaType")
                            val mediaType: String? = null,
                        )

                        @Serializable
                        data class PortraitFillImage(
                            @SerialName("filePath")
                            val filePath: String? = null,
                            @SerialName("imageRole")
                            val imageRole: String? = null,
                            @SerialName("link")
                            val link: String? = null,
                            @SerialName("mediaType")
                            val mediaType: String? = null,
                        )

                        @Serializable
                        data class TrackingMetadataJson(
                            @SerialName("ui_is_recommendation")
                            val uiIsRecommendation: Boolean? = null,
                            @SerialName("ui_module_id")
                            val uiModuleId: String? = null,
                            @SerialName("ui_module_title")
                            val uiModuleTitle: String? = null,
                            @SerialName("ui_navigation_section")
                            val uiNavigationSection: String? = null,
                            @SerialName("ui_object_type")
                            val uiObjectType: String? = null,
                        )
                    }
                }

                @Serializable
                data class PageInfo(
                    @SerialName("endCursor")
                    val endCursor: String? = null,
                    @SerialName("hasNextPage")
                    val hasNextPage: Boolean? = null,
                    @SerialName("hasPreviousPage")
                    val hasPreviousPage: Boolean? = null,
                    @SerialName("startCursor")
                    val startCursor: String? = null,
                )
            }
        }
    }
}
