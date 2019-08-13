/**
 * @author gaoxu
 * @date 2019-08-12 16:20
 * @description ... 类
 */
public class HelloService {
    public String sayHello() {
        return "hello";
    }

    public String sayHelloToPerson(String name) {
        if (name == null) {
            name = "nobody";
        }
        return "hello," + name;
    }
}
