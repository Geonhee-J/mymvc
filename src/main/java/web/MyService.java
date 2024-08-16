package web;

public class MyService {
    MyDao myDao; // 필드 DI는 어노테이션만 사용 가능

    public String getModel() {
        return myDao.selectModel();
    }

    public MyService() {

    }

    // 생성자 DI 구현
    public MyService(MyDao myDao) {
        this.myDao = myDao;
    }

    // setter DI 구현
    public void setMyDao(MyDao myDao) {
        this.myDao = myDao;
    }
}
