import com.mysite.myproject.NavigationEvent

/*
 * By Alexey Che on 2019/11/11
 */

interface PromoNavigation {
    class ShowCategoryList : NavigationEvent()
    class OpenProduct(val productSlug: String) : NavigationEvent()
    class PlayVideo(val url: String) : NavigationEvent()
}
