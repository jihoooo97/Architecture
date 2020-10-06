open class BaseViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    // Observable을 Observing할 때
    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}