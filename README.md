# android-mvp
android - mvp test
3가지의 방법


1. (View에 대한 Interface 구현)
Presenter : Presenter와 View에 대한 interface을 구현
PresenterImpl : Presenter을 상속받아서 구현
View : Presenter.View을 상속받아서 구현


2. (google_ contract 구현)
Contract : View와 Presenter에 대한 interface을 작성
Presenter : Contract.Presenter을 상속받아서 구현
View (Fragment) : Contract.View을 상속받아서 구현


3. (PresenterImpl 구현)
interface View : View에 대한 interface만 정의
Presenter : interface 정의 없이 함수를 생성하여 사용
View : interface View을 상속받아서 정의
