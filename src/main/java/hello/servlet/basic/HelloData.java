package hello.servlet.basic;

/*데이터 파싱
* 잭슨 라이브러리가 기본적으로 getter/setter을 먼저호출함
* */

import lombok.Getter;
import lombok.Setter;

@Getter @Setter  //롬복사용
public class HelloData {

    private String username;
    private int age;

    /*public String getUsername() {
        return username;
    }

    public void setUsername(String username) { //자바 프로퍼티 접근법 set
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }*/
}
