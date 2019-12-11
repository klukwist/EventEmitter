class MyViewModel : ViewModel() {
    val emitter = Events.Enitter()
    
    fun doOnShowCategoryListButtonClicked() = emitter.emitAndExecute(MyNavigation.ShowCategoryList())
    
    fun doOnPlayClicked() = emitter.waitAndExecuteOnce(MyNavigation.PlayVideo(url = "https://site.com/abc"))

    fun doOnProductClicked() = emitter.emitAndExecute(MyNavigation.OpenProduct(
            productId = "123", 
            productTitle = "Часы Sumsung")
        )
    
    fun doOnSwipeRefresh(){
        emitter.clearWaitingEvents()
        ..//loadData()
    }
}
