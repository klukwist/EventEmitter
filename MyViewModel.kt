class MyViewModel : ViewModel() {
    val navigator = ViewModelNavigator()
    
    private var url: String? = null
    private var productId: Int? = null
    private var otherInfo: String? = null
    
    fun doOnPlayClick(){
        navigator.newEvent(MyNavigation.PlayVideo(url))
    }

    fun doOnProductClick(){
        navigator.newEvent(MyNavigation.OpenProduct(productId, otherInfo))
    }
}
