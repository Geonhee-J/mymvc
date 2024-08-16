package web;

public class HelloService {
    HelloDao helloDao;

    public String getHello() {
        return helloDao.selectHello();
    }

    public void setHelloDao(HelloDao helloDao) {
        this.helloDao = helloDao;
    }
}
