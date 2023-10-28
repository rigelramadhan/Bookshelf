package one.reevdev.bookshelf.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class GetBooksResponse(

	@field:SerializedName("totalItems")
	val totalItems: Int,

	@field:SerializedName("kind")
	val kind: String,

	@field:SerializedName("items")
	val items: List<ItemsItem>
)

data class ReadingModes(

	@field:SerializedName("image")
	val image: Boolean,

	@field:SerializedName("text")
	val text: Boolean
)

data class ImageLinks(

	@field:SerializedName("thumbnail")
	val thumbnail: String,

	@field:SerializedName("smallThumbnail")
	val smallThumbnail: String
)

data class SaleInfo(

	@field:SerializedName("country")
	val country: String,

	@field:SerializedName("isEbook")
	val isEbook: Boolean,

	@field:SerializedName("saleability")
	val saleability: String,

	@field:SerializedName("offers")
	val offers: List<OffersItem>,

	@field:SerializedName("buyLink")
	val buyLink: String,

	@field:SerializedName("retailPrice")
	val retailPrice: RetailPrice,

	@field:SerializedName("listPrice")
	val listPrice: ListPrice
)

data class IndustryIdentifiersItem(

	@field:SerializedName("identifier")
	val identifier: String,

	@field:SerializedName("type")
	val type: String
)

data class OffersItem(

	@field:SerializedName("finskyOfferType")
	val finskyOfferType: Int,

	@field:SerializedName("retailPrice")
	val retailPrice: RetailPrice,

	@field:SerializedName("listPrice")
	val listPrice: ListPrice
)

data class Epub(

	@field:SerializedName("isAvailable")
	val isAvailable: Boolean,

	@field:SerializedName("acsTokenLink")
	val acsTokenLink: String
)

data class VolumeInfo(

	@field:SerializedName("industryIdentifiers")
	val industryIdentifiers: List<IndustryIdentifiersItem>,

	@field:SerializedName("pageCount")
	val pageCount: Int,

	@field:SerializedName("printType")
	val printType: String,

	@field:SerializedName("readingModes")
	val readingModes: ReadingModes,

	@field:SerializedName("previewLink")
	val previewLink: String,

	@field:SerializedName("canonicalVolumeLink")
	val canonicalVolumeLink: String,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("language")
	val language: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("imageLinks")
	val imageLinks: ImageLinks,

	@field:SerializedName("subtitle")
	val subtitle: String,

	@field:SerializedName("panelizationSummary")
	val panelizationSummary: PanelizationSummary,

	@field:SerializedName("publisher")
	val publisher: String? = null,

	@field:SerializedName("publishedDate")
	val publishedDate: String,

	@field:SerializedName("categories")
	val categories: List<String>? = null,

	@field:SerializedName("maturityRating")
	val maturityRating: String,

	@field:SerializedName("allowAnonLogging")
	val allowAnonLogging: Boolean,

	@field:SerializedName("contentVersion")
	val contentVersion: String,

	@field:SerializedName("authors")
	val authors: List<String>? = null,

	@field:SerializedName("infoLink")
	val infoLink: String,

	@field:SerializedName("averageRating")
	val averageRating: Int,

	@field:SerializedName("ratingsCount")
	val ratingsCount: Int
)

data class ItemsItem(

	@field:SerializedName("saleInfo")
	val saleInfo: SaleInfo,

	@field:SerializedName("searchInfo")
	val searchInfo: SearchInfo,

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

data class RetailPrice(

	@field:SerializedName("amount")
	val amount: Int,

	@field:SerializedName("currencyCode")
	val currencyCode: String,

	@field:SerializedName("amountInMicros")
	val amountInMicros: Long
)

data class PanelizationSummary(

	@field:SerializedName("containsImageBubbles")
	val containsImageBubbles: Boolean,

	@field:SerializedName("containsEpubBubbles")
	val containsEpubBubbles: Boolean
)

data class AccessInfo(

	@field:SerializedName("accessViewStatus")
	val accessViewStatus: String,

	@field:SerializedName("country")
	val country: String,

	@field:SerializedName("viewability")
	val viewability: String,

	@field:SerializedName("pdf")
	val pdf: Pdf,

	@field:SerializedName("webReaderLink")
	val webReaderLink: String,

	@field:SerializedName("epub")
	val epub: Epub,

	@field:SerializedName("publicDomain")
	val publicDomain: Boolean,

	@field:SerializedName("quoteSharingAllowed")
	val quoteSharingAllowed: Boolean,

	@field:SerializedName("embeddable")
	val embeddable: Boolean,

	@field:SerializedName("textToSpeechPermission")
	val textToSpeechPermission: String
)

data class ListPrice(

	@field:SerializedName("amount")
	val amount: Int,

	@field:SerializedName("currencyCode")
	val currencyCode: String,

	@field:SerializedName("amountInMicros")
	val amountInMicros: Long
)

data class Pdf(

	@field:SerializedName("isAvailable")
	val isAvailable: Boolean,

	@field:SerializedName("acsTokenLink")
	val acsTokenLink: String
)

data class SearchInfo(

	@field:SerializedName("textSnippet")
	val textSnippet: String
)
