import com.quan.dao.CoursewareDao;
import com.quan.pojo.Courseware;
import com.quan.pojo.StudentHomeworkRelation;
import com.quan.pojo.User;
import com.quan.service.CoursewareBiz;
import com.quan.service.LessonBiz;
import com.quan.service.StudentHomeworkRelationBiz;
import com.quan.service.UserBiz;
import com.quan.util.ContextUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class myTest {
    @Test
    public void test(){
        LessonBiz lessonBiz = ContextUtil.getContext().getBean("lessonBiz", LessonBiz.class);
        System.out.println(lessonBiz.getById(1).getLessonName());
        String classpath = this.getClass().getResource("/").getPath().replaceFirst("/", "");
        String webappRoot = classpath.replaceAll("WEB-INF/classes/", "");
        System.out.println(webappRoot);
    }

    @Test
    public void test1() throws ParseException {
        CoursewareBiz coursewareBiz = ContextUtil.getContext().getBean("coursewareBiz", CoursewareBiz.class);
        coursewareBiz.deleteById(9);
    }
}
