package one.reevdev.bookshelf.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class GetBookByIdResponse(

	@field:SerializedName("saleInfo")
	val saleInfo: SaleInfo,

	@field:SerializedName("kind")
	val kind: String,

	@field:SerializedName("volumeInfo")
	val volumeInfo: VolumeInfo,

	@field:SerializedName("etag")
	val etag: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("accessInfo")
	val accessInfo: AccessInfo,

	@field:SerializedName("selfLink")
	val selfLink: String
)