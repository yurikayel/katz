@file:Suppress("PropertyName")

package kayel.app.katz.entity

data class KatResponse(
		val data: List<Kat> = listOf(),
		val status: Int = 0,
		val success: Boolean = false
)
{
	data class Kat(
			val account_id: Int = 0,
			val account_url: String = "",
			val ad_config: AdConfig = AdConfig(),
			val ad_type: Int = 0,
			val ad_url: String = "",
			val animated: Boolean = false,
			val bandwidth: Long = 0,
			val comment_count: Int = 0,
			val cover: String = "",
			val cover_height: Int = 0,
			val cover_width: Int = 0,
			val datetime: Int = 0,
			val description: String = "",
			val downs: Int = 0,
			val edited: Int = 0,
			val favorite: Boolean = false,
			val favorite_count: Int = 0,
			val gifv: String = "",
			val has_sound: Boolean = false,
			val height: Int = 0,
			val hls: String = "",
			val id: String = "",
			val images: List<Image> = listOf(),
			val images_count: Int = 0,
			val in_gallery: Boolean = false,
			val in_most_viral: Boolean = false,
			val include_album_ads: Boolean = false,
			val is_ad: Boolean = false,
			val is_album: Boolean = false,
			val layout: String = "",
			val link: String = "",
			val mp4: String = "",
			val mp4_size: Int = 0,
			val nsfw: Boolean = false,
			val points: Int = 0,
			val privacy: String = "",
			val processing: Processing = Processing(),
			val score: Int = 0,
			val section: String = "",
			val size: Int = 0,
			val tags: List<Tag> = listOf(),
			val title: String = "",
			val topic: Any = Any(),
			val topic_id: Int = 0,
			val type: String = "",
			val ups: Int = 0,
			val views: Int = 0,
			val vote: Any = Any(),
			val width: Int = 0
	)
	{
		data class AdConfig(
				val highRiskFlags: List<Any> = listOf(),
				val high_risk_flags: List<Any> = listOf(),
				val nsfw_score: Double = 0.0,
				val safeFlags: List<String> = listOf(),
				val safe_flags: List<String> = listOf(),
				val showAdLevel: Int = 0,
				val show_ad_level: Int = 0,
				val show_ads: Boolean = false,
				val showsAds: Boolean = false,
				val unsafeFlags: List<String> = listOf(),
				val unsafe_flags: List<String> = listOf(),
				val wallUnsafeFlags: List<Any> = listOf(),
				val wall_unsafe_flags: List<Any> = listOf()
		)
		
		data class Image(
				val account_id: Any = Any(),
				val account_url: Any = Any(),
				val ad_type: Int = 0,
				val ad_url: String = "",
				val animated: Boolean = false,
				val bandwidth: Long = 0,
				val comment_count: Any = Any(),
				val datetime: Int = 0,
				val description: String = "",
				val downs: Any = Any(),
				val edited: String = "",
				val favorite: Boolean = false,
				val favorite_count: Any = Any(),
				val gifv: String = "",
				val has_sound: Boolean = false,
				val height: Int = 0,
				val hls: String = "",
				val id: String = "",
				val in_gallery: Boolean = false,
				val in_most_viral: Boolean = false,
				val is_ad: Boolean = false,
				val link: String = "",
				val mp4: String = "",
				val mp4_size: Int = 0,
				val nsfw: Any = Any(),
				val points: Any = Any(),
				val processing: Processing = Processing(),
				val score: Any = Any(),
				val section: Any = Any(),
				val size: Int = 0,
				val tags: List<Any> = listOf(),
				val title: Any = Any(),
				val type: String = "",
				val ups: Any = Any(),
				val views: Int = 0,
				val vote: Any = Any(),
				val width: Int = 0
		)
		{
			data class Processing(
					val status: String = ""
			)
		}
		
		data class Processing(
				val status: String = ""
		)
		
		data class Tag(
				val accent: String = "",
				val background_hash: String = "",
				val background_is_animated: Boolean = false,
				val description: String = "",
				val description_annotations: DescriptionAnnotations = DescriptionAnnotations(),
				val display_name: String = "",
				val followers: Int = 0,
				val following: Boolean = false,
				val is_promoted: Boolean = false,
				val is_whitelisted: Boolean = false,
				val logo_destination_url: Any = Any(),
				val logo_hash: Any = Any(),
				val name: String = "",
				val thumbnail_hash: String = "",
				val thumbnail_is_animated: Boolean = false,
				val total_items: Int = 0
		)
		{
			class DescriptionAnnotations
		}
	}
}