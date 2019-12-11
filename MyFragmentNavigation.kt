import com.mysite.myproject.NavigationEvent

/*
 * By Alexey Che on 2019/11/11
 */

interface MyFragmentNavigation {
    class ShowCategoryList : NavigationEvent()
    class OpenProduct(val productId: String, val productName: String) : NavigationEvent()
    class PlayVideo(val url: String) : NavigationEvent()
    class ShowNetworkError : NavigationEvent()
}
