package web;

public class ByeService {
    ByeDao byeDao;

    public String getBye() {
        return byeDao.selectBye();
    }

    public void setByeDao(ByeDao byeDao) {
        this.byeDao = byeDao;
    }
}
