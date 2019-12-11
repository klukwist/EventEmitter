class MyViewModel : ViewModel() {
    val emitter = Events.Enitter()
    
    private var url: String? = null
    private var productId: Int? = null
    private var otherInfo: String? = null
        
    fun doOnShowCategoryListButtonClicked() = emitter.emitAndExecute(MyNavigation.ShowCategoryList())
    
    fun doOnPlayClicked() = emitter.emitAndExecuteOnce(MyNavigation.PlayVideo(url))

    fun doOnProductClicked() = emitter.emitAndExecute(MyNavigation.OpenProduct(productId, otherInfo))
    
    fun doOnSwipeRefresh(){
        emitter.emitAndExecute(MyNavigation.OpenProduct(productId, otherInfo))
        ..//loadData()
    }
}
