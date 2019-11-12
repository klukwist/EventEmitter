class MyViewModel : ViewModel() {
    val navigator = ViewModelNavigator()
    
    private var url: String? = null
    private var productId: Int? = null
    private var otherInfo: String? = null
        
    fun doOnShowCategoryListClicked(){
        navigator.newEvent(MyNavigation.ShowCategoryList())
    }
    
    fun doOnPlayClicked(){
        navigator.newEvent(MyNavigation.PlayVideo(url))
    }

    fun doOnProductClicked(){
        navigator.newEvent(MyNavigation.OpenProduct(productId, otherInfo))
    }
}
