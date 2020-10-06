abstract class BaseViewActivity<T: ViewDataBinding, R: BaseViewModel> : AppCompatActivity() {

    lateinit var view_data_binding: T

    // setContentView로 호출할 Layout의 리소스 Id
    abstract val layout_resource_id: Int

    // ViewModel로 쓰일 변수
    abstract val view_model: R

    // layout을 띄운 직후 호출
    // view나 activity의 속성 등을 초기화
    // ex) recyclerView, toolbar, drawerView
    abstract fun initStartView()

    // 2번째로 호출
    // dataBinding 및 rxjava 설정
    abstract fun initDataBinding()

    // Binding 이후에 할 일을 여기에 구현
    // 그 외에 설정할 것이 있으면 여기서 설정
    // clickListener도 여기서 설정
    abstract fun initAterBinding()

    private var is_set_backbutton_valid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        view_data_binding = DataBindingUtil.setContentView(this, layout_resource_id)

        initStartView()
        initDataBinding()
        initAterBinding()
    }

}